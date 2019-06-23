require_relative 'kex_2_battle'
require_relative 'kex_2_enemy'

class Kex_2
  def execute
    puts '冒険が今始まる！'
    player = PlayerEx.new
    continue_game = 1
    kills = 0

    while continue_game != 0
      puts "現HP：#{player.hp}"
      print '奥に進みますか？（１：奥に進む　０．帰る）＞'
      continue_game = gets.chomp.to_i
      if continue_game == 1
        type_no = rand(0..2)
        enemy = create_enemy(type_no)
        result = attack_enemy(player, enemy)
        kills += 1
        
        unless result
          break
        end
      end
    end

    puts "リ〇ミト！\n"
    puts "戦闘回数：#{kills}回　残りHP：#{player.hp}"
  end
end
