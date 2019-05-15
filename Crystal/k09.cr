require "./IExecutable"

class K09 < IExecutable
    def execute(num : Int)
        case num
        when 1
            question_1
        when 2
            question_2
        when 3
            question_3
        when 4
            question_4
        when 5
            question_5
        end
    end
  
    def question_1
        begin
            ages = [] of Int32
            3.times do |x|
                print "#{x + 1}人目の年齢を入力＞"
                ages.push(gets.not_nil!.chomp.to_i)
            end
            print "-" * 20
            puts ""
    
            ages.each_with_index do |x, i|
                puts "#{i + 1}人目：#{x}歳"
            end
            average = ages.sum.to_f / ages.size.to_f
            puts "平均年齢：#{average.round(1)}"
        rescue ex
            puts ex
        end
    end
  
    def question_2
        numbers = [8, 3, 12, 7, 9]
        print "元々の配列："
        numbers.each do |x|
            print "#{x} "
        end
        puts ""
    
        print "逆順での表示："
        numbers.reverse_each do |x|
            print "#{x} "
        end
    end
    
    def question_3
      student_scores = [
        [52, 71, 61, 47],
        [6, 84, 81, 20],
        [73, 98, 94, 95]
      ]
      puts "\t|\t科目A\t科目B\t科目C\t科目D"
      puts "-" * 45
  
      student_scores.each_with_index do |x, i|
        print "学生#{i + 1}\t|\t"
        x.each do |y|
          print "#{y}\t"
        end
        puts ""
      end
    end
    
    def question_4
        student_scores = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
        ]
        total = 0
        average = [0, 0, 0, 0]
        puts "\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点"
        puts "-" * 65
    
        student_scores.each_with_index do |x, i|
            print "学生#{i + 1}\t|\t"
            x.each_with_index do |y, j|
            print "#{y}\t"
            total += y
            average[j] += y
            end
            print "|\t#{total}"
            total = 0
            puts ""
        end
        print "平均点\t|\t"
        average.each do |x|
            print "#{(x.to_f / 3.0).round(1)}\t"
        end
        puts "|"
    end
  
    def question_5
        begin
            numbers = [] of Int32
            100.times do |x|
                print "#{x + 1}件目の入力："
                numbers.push(gets.not_nil!.chomp.to_i)
                break if numbers[x] < 0
            end
            puts "----並び替え後----"
            numbers.pop
            numbers.sort!
            numbers.each do |x|
                puts x
            end
        rescue ex
            puts ex            
        end
    end
  end