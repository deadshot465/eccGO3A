# frozen_string_literal: true

require_relative 'lib/assignments/k01'
require_relative 'lib/assignments/k02'
require_relative 'lib/assignments/k03'
require_relative 'lib/assignments/k04'
require_relative 'lib/assignments/musicians/band_supervisor'

def show_selection(chapter)
  (1..4).each do |x|
    if chapter < 10
      puts "\t#{x}) K0#{chapter}_#{x}"
    else
      puts "\t#{x}) K#{chapter}_#{x}"
    end
  end

  puts "\t5) K0#{chapter}_5" if chapter == 9
end

questions = [K01.new, K02.new, K03.new, K04.new]
puts '実行したいプログラムを選択してください。'
(1..questions.length).each do |x|
  if x < 10
    puts "#{x}) K0#{x}"
  else
    added_number = x >= 12 ? x + 3 : x
    puts "#{x}) K#{added_number}"
  end
end

puts '100) Kex_1'
puts '101) Kex_2'
puts '102) Sort'
puts '103) Band Supervisor'

choice = gets.chomp.to_i

case choice
when 100, 101, 102
  return
when 103
  BandSupervisor.start_band(3)
else
  show_selection(choice)
  choice2 = gets.chomp.to_i
  questions[choice - 1].execute(choice2)
end
