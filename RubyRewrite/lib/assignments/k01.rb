# frozen_string_literal: true

require_relative '../shared/question'

class K01 < Question
  def question1
    puts 'Hello World! ようこそRuby言語の世界へ！'
  end

  def question2
    puts 'Hello World!'
    puts 'ようこそ'
    puts 'Ruby言語の世界へ！'
  end

  def question3
    puts format('整数：%d', 12_345)
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
