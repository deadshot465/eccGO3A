ATTACK_HIT = 110
SKILL_HIT = 100
MAGIC_HIT = 70

def check_hit_or_miss(hit)
  val = rand(0..99)
  val <= hit - 1
end

def attack_golem_ex(lv, player)
  golem = GolemEx.new(lv * 50 + 100, lv * 10 + 40, lv * 10 + 40)
  puts "ゴーレムLv.#{lv + 1}が現れた！"
  while golem.hp > 0
    puts "ゴーレム 残りHP：#{golem.hp}"
    print '武器を選択してください（１．攻撃　２．特技　３．魔法）＞'
    damage = 0
    is_hit = false

    case gets.chomp.to_i
    when 1
      damage = 60 + rand(0..40)
      is_hit = check_hit_or_miss(ATTACK_HIT - golem.flee)
    when 2
      damage = 30 + rand(0..100)
      is_hit = check_hit_or_miss(SKILL_HIT - golem.flee)
    when 3
      damage = 20 + rand(0..180)
      is_hit = check_hit_or_miss(MAGIC_HIT - golem.flee)
    else
      damage = 0
    end

    if is_hit
      damage -= golem.defense
      damage = 0 if damage <= 0
      puts "#{damage}のダメージ！"
      golem.hp -= damage
    else
      puts '攻撃を外した！'
    end

    puts 'ゴーレムの攻撃！'
    is_hit = check_hit_or_miss(golem.hit)
    if is_hit
      injury = golem.attack - player.defense
      puts "#{injury}のダメージ！"
      player.hp -= injury
      if player.hp <= 0
        player.hp = 0
        puts 'あなたはゴーレムに負けました！ゲームオーバー！'
        return player
      end
    else
      puts '攻撃を外した！'
    end

    puts "プレイヤー残りHP：#{player.hp}"
    golem.hp = 0 if golem.hp <= 0
    puts "ゴーレムLv.#{lv + 1}を倒した！" if golem.hp == 0
  end
  player
end
