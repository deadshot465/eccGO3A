class K07
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
    end
  end

  def question1
    choice = 1
    begin
      while choice != 0
        print 'メッセージを表示しますか？（０：終了する　１：表示する）＞'
        choice = gets.chomp.to_i
        show_text if choice == 1
      end
      puts '終了します。'
    rescue TypeError => e
      puts e.message
    end
  end

  def question2
    begin
      numbers = []
      (1..3).each do |x|
        print "#{x}つ目の値を入力してください。＞"
        numbers.append(gets.chomp.to_i)
      end

      puts "#{numbers.count}つの中で最大値は#{get_max_value(numbers[0], numbers[1], numbers[2])}です。"
    rescue TypeError => e
      puts e.message
    end
  end

  def question3
    begin
      age = 0
      no = 0
      puts '年齢を入力して下さい。＞'
      age = gets.chomp.to_i

      no = get_type(age)
      case no
      when 0
        puts '不適切な値が入力されました。'
      when 1
        puts '入場料金無料です。'
      when 2
        puts '子供料金で半額です。'
      when 3
        puts 'シニア割引で１割引きです。'
      else
        puts '通常料金です。'
      end
    rescue TypeError => e
      puts e.message
    end
  end

  def question4; end

  def show_text
    puts 'Hello World!'
    puts 'ようこそ'
    puts 'Ruby言語の世界へ！'
  end

  def get_max_value(value1, value2, value3)
    temp = value1 > value2 ? value1 : value2
    temp = temp > value3 ? temp : value3
    temp
  end

  def get_type(age)
    if age <= 0
      0
    elsif age < 3 || age >= 70
      1
    elsif age >= 3 && age <= 15
      2
    elsif age >= 60 && age < 70
      3
    else
      4
    end
  end
end
