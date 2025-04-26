package easy

import org.scalatest.funsuite.AnyFunSuite

class TwoSumTest extends AnyFunSuite {
  
  test("TwoSum.Case1") {
    assert(TwoSum.solution(Array(2, 7, 11, 15), 9) === Array(0, 1))
  }

  test("TwoSum.Case2") {
    assert(TwoSum.solution(Array(3, 2, 4), 6) === Array(1, 2))
  }

  test("TwoSum.Case3") {
    assert(TwoSum.solution(Array(3, 3), 6) === Array(0, 1))
  }
}
