require_relative 'golem'

class K05
  def execute(num)
    case num
    when 1
      question1
    when 2
      question2
    when 3
      question3
    when 4
      question4
    else
      return
    end
  end

  def question1
    salary = 19.0
    age = 22

    while salary < 50.0
      salary *= 1.035
      age += 1
    end

    puts "#{age}歳で月給#{salary}万円"
  end

  def question2
    begin
      choice = 0

      until choice == 1
        puts '起きろ～'
        print '1．起きた　2．あと5分…　3．Zzzz…\t入力：'
        choice = gets.chomp.to_i
      end
      puts 'よし、学校へ行こう！'
    rescue TypeError => e
      puts e.message
    end
  end

  def question3
    begin
      choice = 0

      loop do
        puts '起きろ～'
        print '1．起きた　2．あと5分…　3．Zzzz…\t入力：'
        choice = gets.chomp.to_i
        puts 'よし、学校へ行こう！' if choice == 1
      end
    rescue TypeError => e
      puts e.message
    end
  end

  def question4
    begin
      golem = Golem.new(300 + rand(0..200))
      player_hp = 200 + rand(0..100)
      puts "ゴーレム　（HP:#{golem.hp}　防御力：#{golem.defense}）"

      while golem.hp > 0
        puts "残りHP：#{golem.hp}"
        print '攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞'
        option = gets.chomp.to_i
        next if option < 1 || option > 3
        damage = 0

        case option
        when 1
          damage = 60 + rand(0..40)
        when 2
          damage = 30 + rand(0..100)
        when 3
          damage = 20 + rand(0..180)
        end

        puts "基礎攻撃力は#{damage}です。"
        damage -= golem.defense

        if damage <= 0
          damage = 0
          puts 'ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」'
          puts "ゴーレムがあなたを攻撃しました！攻撃値：#{golem.attack}"
          player_hp -= golem.attack

          if player_hp <= 0
            puts 'あなたはゴーレムに負けました！ゲームオーバー！'
            return
          end
          puts "あなたの残りHPは：#{player_hp}"
        end
        puts "ダメージは#{damage}です。"
        golem.hp -= damage

        if golem.hp <= 0
          golem.hp = 0
        end
        puts "残りのHPは#{golem.hp}です。"

        if golem.hp == 0
          puts 'ゴーレムを倒しました！'
        end
      end
    rescue TypeError => e
      puts e.message
    end
  end
end