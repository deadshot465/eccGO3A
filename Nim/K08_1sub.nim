proc get_max_value*(v1: int, v2: int, v3: int): int =
    var temp = if v1 >= v2: v1 else: v2
    temp = if temp >= v3: temp else: v3
    return temp

proc get_min_value*(v1: int, v2: int, v3: int): int =
    var temp = if v1 < v2: v1 else: v2
    temp = if temp < v3: temp else: v3
    return temp