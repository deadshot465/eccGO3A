require_relative 'golem'

class K02
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
    seisuu = 3
    jissuu = 2.6
    moji = 'A'

    puts "変数seisuuの値は#{seisuu}"
    puts "変数jissuuの値は#{jissuu}"
    puts "変数mojiの値は#{moji}"
  end

  def question2
    begin
      print '一つ目の整数は？'
      a = gets.chomp.to_i
      print '二つ目の整数は？'
      b = gets.chomp.to_i
      puts format('%d÷%d=%d...%d', a, b, a / b, a % b)
    rescue TypeError => e
      puts e.message
    rescue ZeroDivisionError => e
      puts e.message
    end
  end

  def question3
    begin
      print '一つ目の商品の値段は？'
      priceA = gets.chomp.to_i
      print '個数は？'
      amountA = gets.chomp.to_i
      print '二つ目の商品の値段は？'
      priceB = gets.chomp.to_i
      print '個数は？'
      amountB = gets.chomp.to_i

      total = (priceA * amountA + priceB * amountB) * 1.08
      puts "お支払いは税込み#{total}です"
    rescue TypeError => e
      puts e.message
    end
  end

  def question4
    begin
      golem = Golem.new

      puts "ゴーレム　（HP:#{golem.hp}　防御力：#{golem.defense}）"
      puts "HP：#{golem.hp}"
      print '今回の攻撃の値を入力してください＞'
      damage = gets.chomp.to_i
      damage = damage - golem.defense > 0 ? damage - golem.defense : 0
      puts "ダメージは#{damage}です。"
      golem.hp -= damage
      puts "残りのHPは#{golem.hp}です。"
    rescue TypeError => e
      puts e.message
    end
  end
end