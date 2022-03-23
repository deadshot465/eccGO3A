import random
from multiprocessing.connection import Connection

from assignments.musicians.skill_level import SkillLevel

first_names = ["Valerie", "Arnold", "Carlos", "Dorothy", "Keesha", "Phoebe", "Ralphie", "Tim", "Wanda",
               "Janet", "Leo", "Yuhei", "Carson"]

last_names = ["Frizzle",
              "Perlstein",
              "Ramon",
              "Ann",
              "Franklin",
              "Terese",
              "Tennelli",
              "Jamal",
              "Li",
              "Perlstein",
              "Fujioka",
              "Ito",
              "Hage"]


def pick_name() -> str:
    first_name = random.choice(first_names)
    last_name = random.choice(last_names)
    return f'{first_name} {last_name}'


class Musician:
    def __init__(self, role: str, skill_level: SkillLevel, pipe: Connection):
        self.name = pick_name()
        self.role = role
        self.skill_level = skill_level
        self.pipe = pipe
        print(f'Musician {self.name}, playing the {self.role} entered the room.')

    def play_sound(self) -> bool:
        is_fired = self.pipe.poll(0.5)
        if is_fired:
            print(f'{self.name} just got back to playing in the subway.')
            return False

        match self.skill_level:
            case SkillLevel.GOOD:
                print(f'{self.name} produced sound!')
                return True
            case SkillLevel.BAD:
                failed = random.randint(0, 4) == 0
                if failed:
                    print(f'{self.name} played a false note. Uh oh.')
                    print(f'{self.name} sucks! kicked that member out of the band! ({self.role})')
                else:
                    print(f'{self.name} produced sound!')
                return not failed
            case _:
                return True
