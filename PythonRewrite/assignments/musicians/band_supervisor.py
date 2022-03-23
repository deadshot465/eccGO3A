import time
import typing
from multiprocessing import Pipe, Process, Queue
from multiprocessing.connection import Connection

from assignments.musicians.musician import Musician
from assignments.musicians.skill_level import SkillLevel


delay: typing.Final[float] = 0.75


def start_band(max_retries: int):
    queue = Queue(0)
    members = dict()
    members['singer'] = add_band_member('singer', SkillLevel.GOOD, queue)
    members['bass'] = add_band_member('bass', SkillLevel.GOOD, queue)
    members['drum'] = add_band_member('drum', SkillLevel.BAD, queue)
    members['guitar'] = add_band_member('guitar', SkillLevel.GOOD, queue)
    while True:
        role, skill_level = queue.get(block=True)
        max_retries -= 1
        members[role] = None
        if max_retries <= 0:
            print('The manager is mad and fired the whole band!')
            for conn in members.values():
                if conn is not None:
                    conn.send(0)
            time.sleep(3.0)
            break

        members[role] = add_band_member(role, skill_level, queue)


def add_band_member(role: str, skill_level: SkillLevel, queue: Queue) -> Connection:
    receiver, sender = Pipe(duplex=False)
    musician = Musician(role, skill_level, receiver)
    process = Process(target=loop, args=(musician, queue,), daemon=True)
    process.start()
    return sender


def loop(m: Musician, q: Queue):
    while True:
        time.sleep(delay)
        play_result = m.play_sound()
        if play_result:
            continue

        q.put((m.role, m.skill_level))
        break
