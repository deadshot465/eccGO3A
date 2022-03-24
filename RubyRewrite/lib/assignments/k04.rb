# frozen_string_literal: true

require_relative '../shared/question'

class K04 < Question
  def question1
    print '年齢を入力してください。＞'
    age = gets.chomp.to_i
    puts (age < 3 || age >= 70) ? '入場料金無料です。' : '通常料金です。'
  end

  def question2
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
  end

  def question3
    puts '年齢を入力してください。＞'
    age = gets.chomp.to_i

    case age
    in x if x < 3 || age >= 70
      puts '入場料金無料です。'
    in x if x >= 3 && x <= 15
      puts '子供料金で半額です。'
    in x if x >= 60 && age < 70
      puts 'シニア割引で一割引きです。'
    else
      puts '通常料金です。'
    end
  end

  def question4
    puts '＊＊＊おみくじプログラム＊＊＊'
    print 'おみくじを引きますか　（はい：１　いいえ：０）　＞'
    choice = gets.chomp.to_i

    return if choice < 1

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
end
