require_relative 'attack'

def attack_enemy(player, enemy)
  puts "#{enemy.name}Lv.#{enemy.lv + 1}が現れた！"

  while enemy.hp > 0
    puts "#{enemy.name} 残りHP：#{enemy.hp}"
    print '武器を選択してください（１．攻撃　２．特技　３．魔法）＞'
    choice = gets.chomp.to_i
    get_attack_power = -> { rand(60..100) }
    get_skill_power = -> { rand(30..130) }
    get_magic_power = -> { rand(20..200) }
    get_powers = [get_attack_power, get_skill_power, get_magic_power]
    attacks = [Attack.new, Attack.new, Attack.new]
    get_hits = [ATTACK_HIT, SKILL_HIT, MAGIC_HIT]
    attacks.each_with_index do |item, i|
      item.damage = get_powers[i].call
      item.hit = get_hits[i]
    end

    damage = 0
    is_hit = false

    case choice
    when 1
      damage = attacks[0].damage
      is_hit = check_hit_or_miss(attacks[0].hit - enemy.flee)
    when 2
      damage = attacks[1].damage
      is_hit = check_hit_or_miss(attacks[1].hit - enemy.flee)
    when 3
      damage = attacks[2].damage
      is_hit = check_hit_or_miss(attacks[2].hit - enemy.flee)
    end

    if is_hit
      damage -= enemy.defense
      damage = 0 if damage <= 0
      puts "#{damage}のダメージ！"
      enemy.hp -= damage
    else
      puts '攻撃を外した！'
    end

    puts "#{enemy.name}の攻撃！"
    is_hit = check_hit_or_miss(enemy.hit)
    if is_hit
      injury = enemy.attack - player.defense
      injury = 0 if injury <= 0
      puts "#{injury}の攻撃！"
      player.hp -= injury
      if player.hp <= 0
        player.hp = 0
        puts "あなたは#{enemy.name}に負けました！ゲームオーバー！"
        return false
      end
    else
      puts '攻撃を外した！'
    end

    puts "プレイヤー残りHP：#{player.hp}"
    enemy.hp = 0 if enemy.hp <= 0
    if enemy.hp == 0
      puts "#{enemy.name}Lv.#{enemy.lv + 1}を倒した！"
    end
  end
  true
end
