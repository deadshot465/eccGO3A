//
//  K08_1sub.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/11.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public func GetMaxValue(v1: Int, v2: Int, v3: Int) -> Int {
    var temp = v1 >= v2 ? v1 : v2
    temp = temp >= v3 ? temp : v3
    return temp
}

public func GetMinValue(v1: Int, v2: Int, v3: Int) -> Int {
    var temp = v1 < v2 ? v1 : v2
    temp = temp < v3 ? temp : v3
    return temp
}
