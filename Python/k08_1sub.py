def get_max_value(v1, v2, v3):
    temp = v1 if v1 >= v2 else v2
    temp = temp if temp >= v3 else v3
    return temp

def get_min_value(v1, v2, v3):
    temp = v1 if v1 < v2 else v2
    temp = temp if temp < v3 else v3
    return temp
