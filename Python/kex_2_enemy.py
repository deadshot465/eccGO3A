from random import Random
from enemy import Enemy

MAX_GOLEM_LEVEL = 4
MAX_GOBLIN_LEVEL = 6
MAX_SLIME_LEVEL = 8
GOLEM_HIT = 75
GOLEM_FLEE = 20
GOBLIN_HIT = 85
GOBLIN_FLEE = 40
SLIME_HIT = 95
SLIME_FLEE = 30


def create_enemy(type_no):
    enemy = Enemy()
    random = Random()

    if type_no == 0:
        lv = random.randint(0, MAX_GOLEM_LEVEL)
        enemy = Enemy(lv, lv * 50 + 100, lv * 10 + 40, lv * 10 + 40, GOLEM_HIT, GOLEM_FLEE, 'ゴーレム')
    elif type_no == 1:
        lv = random.randint(0, MAX_GOBLIN_LEVEL)
        enemy = Enemy(lv, lv * 30 + 75, lv * 5 + 20, lv * 5 + 20, GOBLIN_HIT, GOBLIN_FLEE, 'ゴブリン')
    elif type_no == 2:
        lv = random.randint(0, MAX_SLIME_LEVEL)
        enemy = Enemy(lv, lv * 10 + 50, lv * 2 + 10, lv * 2 + 10, SLIME_HIT, SLIME_FLEE, 'スライム')

    return enemy
