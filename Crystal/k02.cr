require "./Golem"
require "./IExecutable"

class K02 < IExecutable
    def question_1()
        seisuu = 3
        jissuu = 2.6
        moji = 'A'

        puts "変数seisuuの値は#{seisuu}"
        puts "変数jissuuの値は#{jissuu}"
        puts "変数mojiの値は#{moji}"
    end

    def question_2()
        begin
            print "一つ目の整数は？"
            a = gets.not_nil!.chomp.to_i
            print "二つ目の整数は？"
            b = gets.not_nil!.chomp.to_i
            puts "#{a}÷#{b}=#{a / b}...#{a % b}"
        rescue e
            puts e.message
        end
    end

    def question_3()
        begin
            print "一つ目の商品の値段は？"
            priceA = gets.not_nil!.chomp.to_i
            print "個数は？"
            amountA = gets.not_nil!.chomp.to_i
            print "二つ目の商品の値段は？"
            priceB = gets.not_nil!.chomp.to_i
            print "個数は？"
            amountB = gets.not_nil!.chomp.to_i
      
            total = (priceA * amountA + priceB * amountB) * 1.08
            puts "お支払いは税込み￥#{total}です"
        rescue e
            puts e.message
        end
    end

    def question_4()
        begin
            golem = Golem.new
      
            puts "ゴーレム　（HP:#{golem.hp}　防御力：#{golem.defense}）"
            puts "HP：#{golem.hp}"
            print "今回の攻撃の値を入力してください＞"
            damage = gets.not_nil!.chomp.to_i
            damage = damage - golem.defense > 0 ? damage - golem.defense : 0
            puts "ダメージは#{damage}です。"
            golem.hp -= damage
            puts "残りのHPは#{golem.hp}です。"

        rescue e
            puts e.message
        end 
    end
end