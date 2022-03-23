import attr


@attr.s(kw_only=True)
class Golem:
    hp: int = attr.ib()
    defense: int = attr.ib()
    attack: int = attr.ib()
