class Golem
  attr_accessor :hp
  attr_reader :defense, :attack

  def initialize(hp = 300, defense = 80, attack = 50)
    @hp = hp
    @defense = defense
    @attack = attack
  end
end
