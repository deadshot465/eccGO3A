from random import Random
from attack import Attack
from kex_1sub import check_hit_or_miss, ATTACK_HIT, SKILL_HIT, MAGIC_HIT


def attack_enemy(player, enemy):
    print('%sLv.%dが現れた！' % (enemy.name, enemy.lv + 1))

    while enemy.hp > 0:
        print('%s 残りHP：%d' % (enemy.name, enemy.hp))

        try:
            choice = int(input('武器を選択してください（１．攻撃　２．特技　３．魔法）＞'))
            random = Random()
            get_attack_power = lambda: random.randint(0, 40) + 60
            get_skill_power = lambda: random.randint(0, 100) + 30
            get_magic_power = lambda: random.randint(0, 180) + 20
            attacks = []
            get_powers = [get_attack_power, get_skill_power, get_magic_power]
            get_hits = [ATTACK_HIT, SKILL_HIT, MAGIC_HIT]

            for x in range(0, 3):
                attacks.append(Attack(get_powers[x](), get_hits[x]))

            attack_dispatcher = {
                1: {
                    'damage': attacks[0].damage,
                    'is_hit': check_hit_or_miss(attacks[0].hit - enemy.flee)
                },
                2: {
                    'damage': attacks[1].damage,
                    'is_hit': check_hit_or_miss(attacks[1].hit - enemy.flee)
                },
                3: {
                    'damage': attacks[2].damage,
                    'is_hit': check_hit_or_miss(attacks[2].hit - enemy.flee)
                }
            }

            damage = attack_dispatcher.get(choice)['damage']
            is_hit = attack_dispatcher.get(choice)['is_hit']

            if is_hit:
                damage -= enemy.defense
                damage = 0 if damage <= 0 else damage
                print('%dのダメージ！' % damage)
                enemy.hp -= damage
            else:
                print('攻撃を外した！')

            print('%sの攻撃！' % enemy.name)
            is_hit = check_hit_or_miss(enemy.hit)
            if is_hit:
                injury = enemy.attack - player.defense
                injury = 0 if injury <= 0 else injury
                print('%dのダメージ！' % injury)
                player.hp -= injury
                if player.hp <= 0:
                    player.hp = 0
                    print('あなたは%sに負けました！ゲームオーバー！' % enemy.name)
                    return False
            else:
                print('攻撃を外した！')

            print('プレイヤー残りHP：%d' % player.hp)
            enemy.hp = 0 if enemy.hp <= 0 else enemy.hp
            if enemy.hp == 0:
                print('%sLv.%dを倒した！' % (enemy.name, enemy.lv + 1))
        except ValueError as ve:
            print(ve)

    return True
