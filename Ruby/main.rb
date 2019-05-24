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
require_relative 'kex'
require_relative 'file_control'

def show_selection(chapter)
  (1..4).each do |x|
    if chapter < 10
      puts "\t#{x}) K0#{chapter}_#{x}"
      puts "\t5) K0#{chapter}_5" if chapter == 9
    else
      puts "\t#{x}) K#{chapter}_#{x}"
    end
  end

end

executables = [K01.new, K02.new, K03.new, K04.new,
               K05.new, K06.new, K07.new, K08.new,
               K09.new, K10.new, K11.new,
               FileControl.new]
puts '実行したいプログラムを選択してください。'

(1..executables.count).each do |x|
  if x < 10
    puts "#{x}) K0#{x}"
  else
    puts "#{x}) K#{x}"
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

