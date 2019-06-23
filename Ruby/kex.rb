require_relative 'player'
require_relative 'kex_1sub'

class Kex
  def execute
    puts '冒険が今始まる！'
    player = PlayerEx.new
    continue_game = 1
    kills = 0

    while continue_game != 0
      puts "現HP：#{player.hp}"
      print '奥に進みますか？（１：奥に進む　０．帰る）＞'
      continue_game = gets.chomp.to_i
      if continue_game != 0
        golem_lv = rand(0..4)
        attack_golem_ex(golem_lv, player)
        kills += 1
        break if player.hp.zero?
      end
    end
    puts 'リ〇ミト！'
    puts "戦闘回数：#{kills}　残りHP：#{player.hp}"
  end
end