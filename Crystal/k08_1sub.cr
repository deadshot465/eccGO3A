def get_max_value(v1 : Int, v2 : Int, v3 : Int) : Int
    temp = v1 >= v2 ? v1 : v2
    temp = temp >= v3 ? temp : v3
end

def get_min_value(v1 : Int, v2 : Int, v3 : Int) : Int
    temp = v1 < v2 ? v1 : v2
    temp = temp < v3 ? temp : v3
    return temp
end