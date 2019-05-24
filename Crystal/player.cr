PLAYER_INITIAL_HP = 500
PLAYER_DEFENSE = 30

struct PlayerEx
    property hp, defense

    def initialize(@hp : Int32 = PLAYER_INITIAL_HP, @defense : Int32 = PLAYER_DEFENSE)
        
    end
end