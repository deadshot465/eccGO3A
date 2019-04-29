require_relative 'k01'
require_relative 'k02'
require_relative 'k03'
require_relative 'k04'
require_relative 'k05'
require_relative 'k06'

def show_selection(chapter)
  (1..4).each do |x|
    puts "\t#{x}) K0#{chapter}_#{x}"
  end
end

executables = [K01.new, K02.new, K03.new, K04.new, K05.new, K06.new]
puts '実行したいプログラムを選択してください。'

(1..6).each do |x|
  puts "#{x}) K0#{x}"
end

begin
  choice = gets.chomp.to_i
  show_selection(choice)
  choice2 = gets.chomp.to_i
  executables[choice - 1].execute(choice2)
rescue TypeError => e
  puts '無効の選択です。'
  puts e.message
end

