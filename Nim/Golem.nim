type Golem* = ref object of RootObj
    hp*: int
    defense*: int
    attack*: int

type GolemEx* = ref object of RootObj
    hp*: int
    defense*: int
    attack*: int
    hit*: int
    flee*: int