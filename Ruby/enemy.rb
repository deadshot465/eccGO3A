class Enemy
  attr_reader :lv
  attr_accessor :hp
  attr_reader :defense
  attr_reader :attack
  attr_reader :hit
  attr_reader :flee
  attr_reader :name

  def initialize(lv = 0, hp = 0, defense = 0, attack = 0, hit = 0, flee = 0, name = '')
    @lv = lv
    @hp = hp
    @defense = defense
    @attack = attack
    @hit = hit
    @flee = flee
    @name = name
  end
end
