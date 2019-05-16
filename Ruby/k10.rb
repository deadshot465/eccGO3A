require_relative 'executable'

class K10 < Executable
  def question1
    print '文字列の入力＞'
    input_str = gets.chomp
    puts "入力された文字列の文字数：#{input_str.size}"
  end

  def question2
    str = 'STRINGcopy'
    puts "コピーしたい文字列：#{str}"
    copy_str = str
    puts "コピー後の文字列：#{copy_str}"
  end

  def question3
    str = %w[abcdef GHIJKL 13579]
    str_combined = ''
    puts '連結したい３つの文字列：'
    str.each do |x|
      puts x
      str_combined += x
    end
    puts "連結した文字列：#{str_combined}"
  end

  def question4
    alphabets = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    input_string = 'I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING.'
    count = 0
    _count = 0

    puts "文字列：#{input_string}"
    puts "\n文字頻度"
    alphabets.each_char do |x|
      input_string.each_char do |y|
        count += 1 if x == y
      end
      print "#{x}: #{count}\t"
      count = 0
      _count += 1
      puts '' if (_count % 4).zero?
    end
  end
end
