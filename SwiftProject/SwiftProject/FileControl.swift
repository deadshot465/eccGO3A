//
//  FileControl.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/12.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

class FileControl : IDispatchable {
    
    func Question1() {
        
        let path = "output.txt"
        let outputString = "This is the string to write.\n"
        
        do {
            try outputString.write(toFile: path, atomically: false, encoding: String.Encoding.utf8)
        } catch let error as NSError {
            print("Error: \(error)")
        }
        
        print("Completed.")
    }
    
    func Question2() {
        return
    }
    
    func Question3() {
        return
    }
    
    func Question4() {
        return
    }
    
    
}
