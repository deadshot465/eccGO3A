require "./IExecutable"

class K03 < IExecutable
    def question_1
        begin
            print "年齢を入力してください。＞"
            age = gets.not_nil!.chomp.to_i
            puts "未成年なので購入できません。" if age < 20
        rescue e
            puts e.message
        end
    end

    def question_2
        begin
            print "身長を入力してください。＞"
            height = gets.not_nil!.chomp.to_f
            height /= 100.0
            print "体重を入力してください。＞"
            weight = gets.not_nil!.chomp.to_f
            standard = height * height * 22.0
            puts "あなたの標準体重は#{standard}です。"
    
            if weight > standard && (weight - standard) / standard * 100 > 14
                puts "太り気味です。"
            elsif weight < standard && (weight - standard) / standard * 100 < -14
                puts "痩せ気味です。"
            else
                puts "普通ですね。"
            end
        rescue e
            puts e.message
        end
    end

    def question_3
        begin
            number = rand(0..99)
            puts "０から９９の範囲の数値が決定されました。"
            print "決められた数値を予想し、この数値よりも大きな値を入力してください＞"
            guess = gets.not_nil!.chomp.to_i
            puts "決められた数値は#{number}です。"
            puts guess > number ? "正解です。" : "不正解です。"
        rescue e
            puts e.message
        end
    end

    def question_4
        begin
            number = rand(0..99)
            puts "０から９９の範囲の数値が決定されました。"
            print "決められた数値を予想し、この数値よりも大きな値を入力してください＞"
            guess = gets.not_nil!.chomp.to_i
            puts "決められた数値は#{number}です。"

            if guess < 0 || guess > 100
                puts "反則です！"
            elsif guess > number && guess - number <= 10
                puts "大正解です！"
            elsif guess < number && guess - number >= -10
                puts "惜しい！"
            elsif guess == number
                puts "お見事！"
            else
                puts guess > number ? "正解です。" : "不正解です。"
            end
        rescue e
            puts e.message
        end
    end
end