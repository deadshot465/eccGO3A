import XCTest
@testable import SwiftAssignments

class SwiftTests: XCTestCase {

    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testPlus() throws {
        XCTAssertEqual(5.0, rpn(input: "2 3 +"))
    }

    func testMinus() throws {
        XCTAssertEqual(87.0, rpn(input: "90 3 -"))
    }

    func testMultiply() throws {
        XCTAssertEqual(-4.0, rpn(input: "10 4 3 + 2 * -"))
    }

    func testDivide() throws {
        XCTAssertEqual(-2.0, rpn(input: "10 4 3 + 2 * - 2 /"))
    }

    func testBadInput() throws {
        XCTAssertEqual(nil, rpn(input: "90 34 12 33 55 66 + * - +"))
    }

    func testComplexInput() throws {
        XCTAssertEqual(4037.0, rpn(input: "90 34 12 33 55 66 + * - + -"))
    }

    func testPower() throws {
        XCTAssertEqual(8.0, rpn(input: "2 3 ^"))
    }

    func testSqrt() throws  {
        XCTAssertEqual(sqrtf(2.0), rpn(input: "2 0.5 ^"))
    }

    func testLn() throws {
        XCTAssertEqual(logf(2.7), rpn(input: "2.7 ln"))
    }

    func testLog10() throws {
        XCTAssertEqual(log10f(2.7), rpn(input: "2.7 log10"))
    }

    func testSum() throws {
        XCTAssertEqual(50.0, rpn(input: "10 10 10 20 sum"))
    }

    func testSumAndDivide() throws {
        XCTAssertEqual(10.0, rpn(input: "10 10 10 20 sum 5 /"))
    }

    func testProduct() throws {
        XCTAssertEqual(1000.0, rpn(input: "10 10 20 0.5 prod"))
    }

    func testPerformanceExample() throws {
        // This is an example of a performance test case.
        measure {
            // Put the code you want to measure the time of here.
        }
    }

}
