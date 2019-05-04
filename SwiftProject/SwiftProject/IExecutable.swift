//
//  IExecutable.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/05.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class IExecutable : IDispatchable {
    
    public func Execute(num: Int) {
        switch num {
        case 1:
            Question1()
        case 2:
            Question2()
        case 3:
            Question3()
        case 4:
            Question4()
        default:
            break
        }
    }
    
    public func Question1() {
        return
    }
    
    public func Question2() {
        return
    }
    
    public func Question3() {
        return
    }
    
    public func Question4() {
        return
    }
    
}
