from strutils import parseInt
import Golem

type AttackMethod = enum
    Attack = 65, Skill = 99, Magic = 133

proc attack_golem*(lv: int, playerHp: var int) =
    var golem = Golem(hp: lv * 50 + 100, defense: lv * 10 + 40, attack: lv * 10 + 30)
    
    echo "ゴーレムLv.", lv + 1, "が現れた！"
    while golem.hp > 0:
        echo "\n残りHP：", golem.hp
        stdout.write "武器を選択してください（１．攻撃　２．特技　３．魔法）＞"
        stdout.flushFile
        var choice = parseInt(readLine(stdin))
        var damage: int
        case choice
        of 1:
            damage = ord(AttackMethod.Attack)
        of 2:
            damage = ord(AttackMethod.Skill)
        of 3:
            damage = ord(AttackMethod.Magic)
        else:
            damage = 0
        
        damage -= golem.defense
        if damage <= 0:
            damage = 0
            echo "ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」"
            echo "ゴーレムがあなたを攻撃しました！攻撃値：", golem.attack
            playerHp -= golem.attack
            if playerHp <= 0:
                playerHp = 0
                echo "あなたはゴーレムに負けました！ゲームオーバー！"
                return
            echo "あなたの残りHPは：", playerHp
        echo "ダメージは", damage, "です。"
        golem.hp -= damage
        
        if golem.hp <= 0:
            golem.hp = 0

        if golem.hp == 0:
            echo "ゴーレムLv.", lv + 1, "を倒した！"