from Golem import GolemEx
from random import Random

ATTACK_HIT = 110
SKILL_HIT = 100
MAGIC_HIT = 70


def check_hit_or_miss(hit):
    rand = Random()
    value = rand.randint(0, 99)
    return value <= (hit - 1)


def attack_golem(lv, player):

    golem = GolemEx(lv * 50 + 100, lv * 10 + 40, lv * 10 + 40)

    print('ゴーレムLv.%dが現れた！' % (lv + 1))
    while golem.hp > 0:
        print('ゴーレム 残りHP：%d' % golem.hp)
        print('武器を選択してください（１．攻撃　２．特技　３．魔法）＞', end='')
        choice = int(input())
        rand = Random()
        attack_dispatcher = {
            1: 60 + rand.randint(0, 40),
            2: 30 + rand.randint(0, 100),
            3: 20 + rand.randint(0, 180)
        }
        hit_dispatcher = {
            1: ATTACK_HIT,
            2: SKILL_HIT,
            3: MAGIC_HIT
        }
        damage = attack_dispatcher.get(choice, 0)
        is_hit = check_hit_or_miss(hit_dispatcher.get(choice) - golem.flee)
        if is_hit:
            damage -= golem.defense
            if damage <= 0:
                damage = 0
            print('%dのダメージ！' % damage)
            golem.hp -= damage
        else:
            print('攻撃を外した！')

        print('ゴーレムの攻撃！')
        is_hit = check_hit_or_miss(golem.hit)
        if is_hit:
            injury = golem.attack - player.defense
            print('%dのダメージ！' % injury)
            player.hp -= injury
            if player.hp <= 0:
                player.hp = 0
                print('あなたはゴーレムに負けました！ゲームオーバー！')
                return player
        else:
            print('攻撃を外した！')

        print('プレイヤー残りHP：%d' % player.hp)
        if golem.hp <= 0:
            golem.hp = 0
        if golem.hp == 0:
            print('ゴーレムLv.%dを倒した！' % (lv + 1))
    return player
