from Golem import Golem

def attack_golem(lv, playerHp):
    golem = Golem(lv * 50 + 100, lv * 10 + 40, lv * 10 + 30)
    _playerHp = playerHp
    attack_method = {
        'Attack': 65,
        'Skill': 99,
        'Magic': 133
        }

    print('ゴーレムLv.{}が現れた！'.format(lv + 1))
    while golem.hp > 0:
        print('\n残りHP：{}'.format(golem.hp))
        print('武器を選択してください（１．攻撃　２．特技　３．魔法）＞', end='')
        choice = int(input())
        damage_dispatch = {
            1: attack_method['Attack'],
            2: attack_method['Skill'],
            3: attack_method['Magic']
            }
        damage = damage_dispatch[choice] - golem.defense

        if damage <= 0:
            damage = 0
            print('ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」')
            print('ゴーレムがあなたを攻撃しました！攻撃値：{}'.format(golem.attack))
            _playerHp = damage_player(_playerHp, golem.attack)
            
            if _playerHp <= 0:
                _playerHp = 0
                print('あなたはゴーレムに負けました！ゲームオーバー！')
                return _playerHp
            print('あなたの残りHPは：{}'.format(_playerHp))

        print('ダメージは{}です。'.format(damage))
        golem.hp -= damage

        if golem.hp <= 0:
            golem.hp = 0

        if golem.hp == 0:
            print('ゴーレムLv.{}を倒した！'.format(lv + 1))
    return _playerHp

def damage_player(playerHp, attackPower):
    return playerHp - attackPower