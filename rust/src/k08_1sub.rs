pub fn get_max_value(v1: i32, v2: i32, v3: i32) -> i32 {
    let mut temp = if v1 >= v2 {
        v1
    } else {
        v2
    };

    temp = if temp >= v3 {
        temp
    } else {
        v3
    };

    temp
}

pub fn get_min_value(v1: i32, v2: i32, v3: i32) -> i32 {
    let mut temp = if v1 <= v2 {
        v1
    } else {
        v2
    };

    temp = if temp <= v3 {
        temp
    } else {
        v3
    };

    temp
}