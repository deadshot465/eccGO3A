class Golem
  attr_accessor :hp
  attr_accessor :defense
  attr_accessor :attack

  def initialize(hp = 300, defense = 80, attack = 50)
    @hp = hp
    @defense = defense
    @attack = attack
  end
end

class GolemEx
  GOLEM_HIT = 70
  GOLEM_FLEE = 20
  attr_accessor :hp
  attr_accessor :defense
  attr_accessor :attack
  attr_reader :hit
  attr_reader :flee

  def initialize(hp, defense, attack)
    @hp = hp
    @defense = defense
    @attack = attack
    @hit = GOLEM_HIT
    @flee = GOLEM_FLEE
  end
end