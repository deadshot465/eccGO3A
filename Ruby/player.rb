class PlayerEx
  PLAYER_INITIAL_HP = 500
  PLAYER_DEFENSE = 30
  attr_accessor :hp
  attr_reader :defense

  def initialize
    @hp = PLAYER_INITIAL_HP
    @defense = PLAYER_DEFENSE
  end
end