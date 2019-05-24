require "./k01"
require "./k02"
require "./k03"
require "./k04"
require "./k05"
require "./k06"
require "./k07"
require "./k08"
require "./k09"
require "./k10"
require "./k11"
require "./kex"
require "./file_control"

def show_selection(chapter : Int32)
    (1..4).each do |x|
        if chapter < 10
            puts "\t#{x}) K0#{chapter}_#{x}"
            if chapter == 9
                puts "\t5) K0#{chapter}_5"
            end
        else
            puts "\t#{x}) K#{chapter}_#{x}"
        end
    end
end

executables = [K01.new, K02.new, K03.new, K04.new,
            K05.new, K06.new, K07.new, K08.new,
            K09.new, K10.new, K11.new, FileControl.new]

puts "実行したいプログラムを選択してください。"
(1..executables.size).each do |x|
    if x < 10
        puts "#{x}) K0#{x}"
    else
        puts "#{x}) K#{x}"
    end
end
puts "100) Kex"

choice = gets.not_nil!.chomp.to_i
if choice == 100
    kex = Kex.new
    kex.execute
else
    show_selection(choice)
    choice2 = gets.not_nil!.chomp.to_i
    executables[choice - 1].execute(choice2)
end