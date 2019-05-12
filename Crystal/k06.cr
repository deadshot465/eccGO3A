require "./IExecutable"

class K06 < IExecutable

    def question_1
        begin
            ages = [] of Int32
        
            (0..4).each do |x|
                print "#{x + 1}人目の年齢を入力して下さい："
                ages.push(gets.not_nil!.chomp.to_i)
            end
        
            average = ages.reduce {|x, y| x + y} / ages.size
            puts "#{ages.size}人の平均年齢は#{average}です。"
        rescue e
            puts e.message
        end
    end
    
    def question_2
        (0..8).each do |x|
            (0..x).each do
                print "*"
            end
            puts ""
        end
        puts ""
    
        8.downto(0).each do |x|
            0.upto(x).each do
                print "*"
            end
            puts ""
        end
        puts ""
    
        8.downto(0).each do |x|
            1.upto(x) do
                print " "
            end
    
            8.downto(x) do
                print "*"
            end
            puts ""
        end
        puts ""
    end
    
    def question_3
        total = 370
        count = 0
    
        (0..total / 100).each do |x|
          (0..total / 50).each do |y|
            (0..total / 10).each do |z|
                if 100 * x + 50 * y + 10 * z == 370
                    puts "10円の硬貨#{z}枚 50円の硬貨#{y}枚 100円の硬貨#{x}枚"
                    count += 1
                end
            end
          end
        end
        puts "\n以上#{count}通りを発見しました。"
    end
    
      def question_4
        print "\t|\t"
    
        (1..9).each do |x|  
            print "#{x}\t"
        end
        puts ""
    
        85.times do
            print "-"
        end
        puts ""
    
        (1..9).each do |x|
            print "#{x}\t|\t"
            (1..9).each do |y|
                print "#{x * y}\t"
            end
            puts ""
        end
    end
end