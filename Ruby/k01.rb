class K01
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
    puts 'Hello World! ようこそRuby言語の世界へ！'
  end

  def question2
    puts 'Hello World!'
    puts 'ようこそ'
    puts 'Ruby言語の世界へ！'
  end

  def question3
    puts format('整数：%d', 12345)
    puts format('実数：%f', 123.456789)
    puts format('文字：%c', 'X')
    puts format('文字列：%s', 'ABCdef')
  end

  def question4
    puts '              ##'
    puts '             #  #'
    puts '             #  #'
    puts '            #    #'
    puts '           #      #'
    puts '         ##        ##'
    puts '       ##            ##'
    puts '    ###                ###'
    puts ' ###       ##    ##       ###'
    puts '##        #  #  #  #        ##'
    puts '##         ##    ##         ##'
    puts ' ##     #            #     ##'
    puts '  ###     ##########     ###'
    puts '     ###              ###'
    puts '        ##############'
  end
end