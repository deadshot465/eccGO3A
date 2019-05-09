def get_max_value(v1, v2, v3)
  temp = v1 >= v2 ? v1 : v2
  temp = temp >= v3 ? temp : v3
  temp
end

def get_min_value(v1, v2, v3)
  temp = v1 < v2 ? v1 : v2
  temp = temp < v3 ? temp : v3
  temp
end