require_relative 'executable'

class Person
  attr_accessor :Name
  attr_accessor :BirthYear
  attr_accessor :Height
  attr_accessor :Weight
end

class Staff
  attr_reader :Name
  attr_reader :Gender
  attr_reader :Age

  def initialize(name, gender, age)
    @Name = name
    @Gender = gender
    @Age = age
  end
end

class Position
  attr_accessor :X
  attr_accessor :Y
  attr_accessor :Distance

  def initialize(x = 0, y = 0, distance = 0.0)
    @X = x
    @Y = y
    @Distance = distance
  end
end

class K12 < Executable
  def question1
    person = Person.new
    print '名前を入力してください＞'
    person.Name = gets.chomp
    print '生年（西暦）を入力してください＞'
    person.BirthYear = gets.chomp.to_i
    print '身長を入力してください＞'
    person.Height = gets.chomp.to_f
    print '体重を入力してください＞'
    person.Weight = gets.chomp.to_f

    puts 'プロファイル'
    puts "名前：#{person.Name}"
    puts "生年：#{person.BirthYear}"
    puts "身長：#{person.Height}"
    puts "体重：#{person.Weight}"
  end

  def question2
    staffs = [
        Staff.new('神木隆之介', 'M', 23),
        Staff.new('上白石萌音', 'F', 18),
        Staff.new('長澤まさみ', 'F', 28)
    ]

    puts "名前\t\t性別\t年齢"
    puts '-' * 35
    staffs.each do |staff|
      puts "#{staff.Name}\t#{staff.Gender}\t#{staff.Age}歳"
    end
  end

  def get_distance(player_pos, enemy_pos)
    diff_x = player_pos.X - enemy_pos.X
    diff_y = player_pos.Y - enemy_pos.Y
    Math.sqrt(diff_x * diff_x + diff_y * diff_y)
  end

  def question3
    get_random_number = lambda {|| rand(0..100) - 50}
    player_pos = Position.new(get_random_number.call, get_random_number.call)
    enemy_pos = []
    5.times do
      pos = Position.new(get_random_number.call, get_random_number.call)
      pos.Distance = self.get_distance(player_pos, pos)
      enemy_pos.push(pos)
    end

    printf("プレーヤーの座標：x= %.2f\t\ty= %.2f\n", player_pos.X, player_pos.Y)
    enemy_pos.each_with_index do |pos, i|
      printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n", i, pos.X, pos.Y, pos.Distance)
    end
  end

  def question4
    get_random_number = lambda {|| rand(0..100) - 50}
    player_pos = Position.new(get_random_number.call, get_random_number.call)
    enemy_pos = []
    5.times do
      pos = Position.new(get_random_number.call, get_random_number.call)
      pos.Distance = self.get_distance(player_pos, pos)
      enemy_pos.push(pos)
    end

    printf("プレーヤーの座標：x= %.2f\t\ty= %.2f\n", player_pos.X, player_pos.Y)
    enemy_pos.each_with_index do |pos, i|
      printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n", i, pos.X, pos.Y, pos.Distance)
    end

    puts "\n並び替え後"
    enemy_pos.sort! { |a, b| a.Distance <=> b.Distance }
    enemy_pos.each_with_index do |pos, i|
      printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n", i, pos.X, pos.Y, pos.Distance)
    end
  end
end