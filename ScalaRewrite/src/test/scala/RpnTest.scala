import assignments.extra.rpn

import org.scalatest.flatspec.AnyFlatSpec

class RpnSpec extends AnyFlatSpec:
  "2 3 +" should "return 5.0" in {
    assert(rpn("2 3 +") == Some(5.0))
  }

  "90 3 -" should "return 87.0" in {
    assert(rpn("90 3 -") == Some(87.0))
  }

  "10 4 3 + 2 * -" should "return -4.0" in {
    assert(rpn("10 4 3 + 2 * -") == Some(-4.0))
  }

  "10 4 3 + 2 * - 2 /" should "return -2.0" in {
    assert(rpn("10 4 3 + 2 * - 2 /") == Some(-2.0))
  }

  "90 34 12 33 55 66 + * - +" should "return None" in {
    assert(rpn("90 34 12 33 55 66 + * - +") == None)
  }

  "90 34 12 33 55 66 + * - + -" should "return 4037.0" in {
    assert(rpn("90 34 12 33 55 66 + * - + -") == Some(4037.0))
  }

  "2 3 ^" should "return 8.0" in {
    assert(rpn("2 3 ^") == Some(8.0))
  }

  "2 0.5 ^" should "return sqrt(2.0)" in {
    assert(rpn("2 0.5 ^") == Some(Math.sqrt(2.0).toFloat))
  }

  "2.7 ln" should "return log(2.7)" in {
    assert(rpn("2.7 ln") == Some(Math.log(2.7).toFloat))
  }

  "2.7 log10" should "return log10(2.7)" in {
    assert(rpn("2.7 log10") == Some(Math.log10(2.7).toFloat))
  }

  "10 10 10 20 sum" should "return 50.0" in {
    assert(rpn("10 10 10 20 sum") == Some(50.0))
  }

  "10 10 10 20 sum 5 /" should "return 10.0" in {
    assert(rpn("10 10 10 20 sum 5 /") == Some(10.0))
  }

  "10 10 20 0.5 prod" should "return 1000.0" in {
    assert(rpn("10 10 20 0.5 prod") == Some(1000.0))
  }
