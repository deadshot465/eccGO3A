require "./k01"
require "./k02"
require "./k03"
require "./k04"
require "./k05"
require "./k06"
require "./k07"
require "./k08"
require "./file_control"

def show_selection(chapter : Int32)
    (1..4).each do |x|
        puts "\t#{x}) K0#{chapter}_#{x}"
    end
end

executables = [K01.new, K02.new, K03.new, K04.new,
            K05.new, K06.new, K07.new, K08.new,
            FileControl.new]

puts "実行したいプログラムを選択してください。"
(1..executables.size).each do |x|
    puts "#{x}) K0#{x}"
end

choice = gets.not_nil!.chomp.to_i
show_selection(choice)
choice2 = gets.not_nil!.chomp.to_i
executables[choice - 1].execute(choice2)