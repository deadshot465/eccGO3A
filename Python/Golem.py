class Golem(object):
    
    def __init__(self, hp=300, defense=80, attack=50):
        self.hp = hp
        self.defense = defense
        self.attack = attack


class GolemEx(object):
    HIT = 70
    FLEE = 20

    def __init__(self, hp, defense, attack):
        self.hp = hp
        self.defense = defense
        self.attack = attack
        self.hit = self.HIT
        self.flee = self.FLEE