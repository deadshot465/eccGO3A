require "./Golem"

def attack_golem(lv : Int, player_hp : Int) : Int
    begin
      golem = Golem.new(lv * 50 + 100, lv * 10 + 40, lv * 10 + 30)
      _playerHp = player_hp
      attack_method = {
          :Attack => 65,
          :Skill => 99,
          :Magic => 133
      }
  
      puts "ゴーレムLv.#{lv + 1}が現れた！"
      while golem.hp > 0
        puts "\n残りHP：#{golem.hp}"
        print "武器を選択してください（１．攻撃　２．特技　３．魔法）＞"
        choice = gets.not_nil!.chomp.to_i
        damage = 0
        case choice
        when 1
            damage = attack_method[:Attack]
        when 2
            damage = attack_method[:Skill]
        when 3
            damage = attack_method[:Magic]
        end
        damage -= golem.defense
  
        if damage <= 0
            damage = 0
            puts "ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」"
            puts "ゴーレムがあなたを攻撃しました！攻撃値：#{golem.attack}"
            _playerHp = damage_playerHp(_playerHp, golem.attack)
    
            if _playerHp <= 0
                _playerHp = 0
                puts "あなたはゴーレムに負けました！ゲームオーバー！"
                return _playerHp
            end
            puts "あなたの残りHPは：#{_playerHp}"
        end
        puts "ダメージは#{damage}です。"
        golem.hp -= damage
  
        if golem.hp <= 0
            golem.hp = 0
        end
  
        if golem.hp == 0
            puts "ゴーレムLv.#{lv + 1}を倒した！"
        end
      end
      return _playerHp
    rescue e  
        puts e.message
        return 0
    end
end
  
  def damage_playerHp(player_hp : Int, attack_power : Int) : Int
    return player_hp - attack_power
  end