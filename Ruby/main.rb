require_relative 'k01'
require_relative 'k02'
require_relative 'k03'
require_relative 'k04'
require_relative 'k05'
require_relative 'k06'
require_relative 'k07'
require_relative 'k08'
require_relative 'k09'
require_relative 'k10'
require_relative 'k11'
require_relative 'k12'
require_relative 'kex'
require_relative 'file_control'

def show_selection(chapter)
  if chapter < 10
    (1..4).each do |x|
      puts "\t#{x}) K0#{chapter}_#{x}"
    end
    puts "\t5) K0#{chapter}_5" if chapter == 9
  else
    added_number = chapter >= 12 ? chapter + 3 : chapter
    (1..4).each do |x|
      puts "\t#{x}) K#{added_number}_#{x}"
    end
  end
end

executables = [K01.new, K02.new, K03.new, K04.new,
               K05.new, K06.new, K07.new, K08.new,
               K09.new, K10.new, K11.new, K12.new,
               FileControl.new]
puts '実行したいプログラムを選択してください。'

(1..executables.count).each do |x|
  if x < 10
    puts "#{x}) K0#{x}"
  else
    added_number = x >= 12 ? x + 3 : x
    puts "#{x}) K#{added_number}"
  end
end
puts '100) Kex'

begin
  choice = gets.chomp.to_i
  if choice == 100
    kex = Kex.new
    kex.execute
  else
    show_selection(choice)
    choice2 = gets.chomp.to_i
    executables[choice - 1].execute(choice2)
  end
rescue TypeError => e
  puts '無効の選択です。'
  puts e.message
end

