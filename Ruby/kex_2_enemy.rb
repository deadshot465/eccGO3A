require_relative 'enemy'

MAX_GOLEM_LEVEL = 4
MAX_GOBLIN_LEVEL = 6
MAX_SLIME_LEVEL = 8
GOLEM_HIT = 75
GOLEM_FLEE = 20
GOBLIN_HIT = 85
GOBLIN_FLEE = 40
SLIME_HIT = 95
SLIME_FLEE = 30

def create_enemy(type_no)
  enemy = Enemy.new

  case type_no
  when 0
    lv = rand(0..MAX_GOLEM_LEVEL)
    enemy = Enemy.new(lv, lv * 50 + 100, lv * 10 + 40, lv * 10 + 40, GOLEM_HIT, GOLEM_FLEE, 'ゴーレム')
  when 1
    lv = rand(0..MAX_GOBLIN_LEVEL)
    enemy = Enemy.new(lv, lv * 30 + 75, lv * 5 + 20, lv * 5 + 20, GOBLIN_HIT, GOBLIN_FLEE, 'ゴブリン')
  when 2
    lv = rand(0..MAX_SLIME_LEVEL)
    enemy = Enemy.new(lv, lv * 10 + 50, lv * 2 + 10, lv * 2 + 10, SLIME_HIT, SLIME_FLEE, 'スライム')
  end

  enemy
end
