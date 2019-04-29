class K04
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
    begin
      print '年齢を入力してください。＞'
      age = gets.chomp.to_i
      puts (age < 3 || age >= 70) ? '入場料金無料です。' : '通常料金です。'
    rescue TypeError => e
      puts e.message
    end
  end

  def question2
    begin
      print '性別を選択してください。（０：男性　１：女性）＞'
      gender = gets.chomp.to_f

      case gender
      when 0
        puts 'あら、格好良いですね。'
      when 1
        puts 'あら、モデルさんみたいですね。'
      else
        puts 'そんな選択肢はありません。'
      end
    rescue TypeError => e
      puts e.message
    end
  end

  def question3
    begin
      puts '年齢を入力してください。＞'
      age = gets.chomp.to_i

      if age < 3 || age >= 70
        puts '入場料金無料です。'
      elsif age >= 3 && age <= 15
        puts '子供料金で半額です。'
      elsif age >= 60 && age < 70
        puts 'シニア割引で一割引きです。'
      else
        puts '通常料金です。'
      end
    rescue TypeError => e
      puts e.message
    end
  end

  def question4
    begin
      puts '＊＊＊おみくじプログラム＊＊＊'
      print 'おみくじを引きますか　（はい：１　いいえ：０）　＞'
      choice = gets.chomp.to_i

      if choice >= 1
        oracle = rand(0..4)

        case oracle
        when 0
          puts '大吉　とってもいいことがありそう！！'
        when 1
          puts '中吉　きっといいことあるんじゃないかな'
        when 2
          puts '小吉　少しぐらいはいいことあるかもね'
        when 3
          puts '凶　今日はおとなしくておいた方がいいかも'
        when 4
          puts '大凶　これじゃやばくない？早く家に帰った方がいいかも'
        end
      end

    rescue TypeError => e
      puts e.message
    end
  end
end