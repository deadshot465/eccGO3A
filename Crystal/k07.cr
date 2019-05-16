require "./IExecutable"

class K07 < IExecutable

    def question_1
        choice = 1
        begin
            while choice != 0
                print "メッセージを表示しますか？（０：終了する　１：表示する）＞"
                choice = gets.not_nil!.chomp.to_i
                show_text if choice == 1
            end
            puts "終了します。"
        rescue e
            puts e.message
        end
    end
    
    def question_2
        numbers = [] of Int32
        begin
            (1..3).each do |x|
                print "#{x}つ目の値を入力してください。＞"
                numbers.push(gets.not_nil!.chomp.to_i)
            end
    
            puts "#{numbers.size}つの中で最大値は#{get_max_value(numbers[0], numbers[1], numbers[2])}です。"
        rescue e
            puts e.message
        end
    end
    
    def question_3
        begin
            age = 0
            no = 0
            puts "年齢を入力して下さい。＞"
            age = gets.not_nil!.chomp.to_i
        
            no = get_type(age)
            case no
            when 0
                puts "不適切な値が入力されました。"
            when 1
                puts "入場料金無料です。"
            when 2
                puts "子供料金で半額です。"
            when 3
                puts "シニア割引で１割引きです。"
            else
                puts "通常料金です。"
            end
        rescue e
            puts e.message
        end
    end
    
    def question_4; end
    
    def show_text
        puts "Hello World!"
        puts "ようこそ"
        puts "Crystal言語の世界へ！"
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