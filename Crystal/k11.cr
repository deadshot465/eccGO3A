require "./IExecutable"

class K11 < IExecutable
    
    MAX_PEOPLE = 5

    def question_1
        begin
            ages = [] of Int32
      
            (0..MAX_PEOPLE - 1).each do |x|
              print "#{x + 1}人目の年齢を入力して下さい："
              ages.push(gets.not_nil!.chomp.to_i)
            end
      
            average = ages.reduce {|x, y| x + y} / ages.size
            puts "#{ages.size}人の平均年齢は#{average}です。"
          rescue e
            puts e
          end
    end
    
    def question_2
        print "1つ目の文字列を入力して下さい。＞"
        str1 = gets.not_nil!.chomp
        print "2つ目の文字列を入力して下さい。＞"
        str2 = gets.not_nil!.chomp
        str1 += str2
        puts "#{str1}の文字数は#{str1.size}です。"
    end
    
    def question_3
        chr = ""
        print "文字を入力して下さい。＞"
        chr = gets.not_nil!.chomp
        applied = false
        if chr =~ /[0-9]/
        puts "この文字は数字です。"
        applied = true
        end
        if chr =~ /[A-Z]/
        puts "この文字は英大文字です。"
        applied = true
        end
        if chr =~ /[a-z]/
        puts "この文字は英小文字です。"
        applied = true
        end
        if chr =~ /[A-Fa-f0-9]/
        puts "この文字は16進数として使える文字です。"
        applied = true
        end
        if chr =~ /(.|,|!|\?|:|;|"|'|-|\(|\))/
        puts "この文字は区切り文字です。"
        applied = true
        end
        puts "この文字はよくわからない文字です。" unless applied
    end
    
    def question_4
        alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        input_string = "I am a STUDENT. I am good at GAME PROGRAMMING."
        count = 0
        _count = 0
    
        puts "文字列：#{input_string}"
        puts "\n文字頻度"
        alphabets.each_char do |x|
            input_string.each_char do |y|
                count += 1 if x == y.upcase
            end
            print "#{x}: #{count}\t"
            count = 0
            _count += 1
            puts "" if (_count % 4).zero?
        end
    end
  end