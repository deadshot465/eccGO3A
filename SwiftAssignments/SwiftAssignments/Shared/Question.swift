import Foundation

protocol Question {
    func question1()
    func question2()
    func question3()
    func question4()
}

extension Question {
    func execute(number: Int) {
        switch number {
        case 1:
            question1()
        case 2:
            question2()
        case 3:
            question3()
        case 4:
            question4()
        default:
            break
        }
    }
}