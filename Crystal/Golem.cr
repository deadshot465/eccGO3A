GOLEM_HIT = 70
GOLEM_FLEE = 20

struct Golem
    property hp, defense, attack

    def initialize(@hp : Int32 = 300, @defense : Int32 = 80, @attack : Int32 = 50)
        
    end
end

struct GolemEx
    property hp, defense, attack, hit, flee

    def initialize(@hp : Int32, @defense : Int32, @attack : Int32)
        @hit = GOLEM_HIT
        @flee = GOLEM_FLEE
    end
end