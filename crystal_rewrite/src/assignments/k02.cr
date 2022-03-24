require "../shared/golem"
require "../shared/question"

class K02 < Question
    def question1
        seisuu = 3
        jissuu = 2.6
        moji = 'A'

        puts "変数seisuuの値は#{seisuu}"
        puts "変数jissuuの値は#{jissuu}"
        puts "変数mojiの値は#{moji}"
    end

    def question2
        print "一つ目の整数は？"
        a = gets.not_nil!.chomp.to_i
        print "二つ目の整数は？"
        b = gets.not_nil!.chomp.to_i
        puts "#{a}÷#{b}=#{a / b}...#{a % b}"
    end

    def question3
        print "一つ目の商品の値段は？"
        price_a = gets.not_nil!.chomp.to_i
        print "個数は？"
        amount_a = gets.not_nil!.chomp.to_i
        print "二つ目の商品の値段は？"
        price_b = gets.not_nil!.chomp.to_i
        print "個数は？"
        amount_b = gets.not_nil!.chomp.to_i

        total = (price_a * amount_a + price_b * amount_b) * 1.1
        puts "お支払いは税込み#{total}です"
    end

    def question4
        golem = Golem.new(300, 80, 50)
        puts "ゴーレム　（HP:#{golem.hp}　防御力：#{golem.defense}）"
        puts "HP：#{golem.hp}"
        print "今回の攻撃の値を入力してください＞"
        damage = gets.not_nil!.chomp.to_i
        damage = (damage - golem.defense).positive? ? damage - golem.defense : 0
        puts "ダメージは#{damage}です。"
        golem.hp -= damage
        puts "残りのHPは#{golem.hp}です。"
    end
end