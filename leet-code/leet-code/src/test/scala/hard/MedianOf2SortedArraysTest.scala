package hard

import org.scalatest.funsuite.AnyFunSuite

class MedianOf2SortedArraysTest extends AnyFunSuite {
  test("AddTwoNumbers.Case1") {
    assert(MedianOf2SortedArrays.solution(Array(1,3), Array(2,4)) == 2.5)
  }

  test("AddTwoNumbers.Case2") {
    assert(MedianOf2SortedArrays.solution(Array(1,2,5), Array(3,5,6)) == 4.0)
  }

  test("AddTwoNumbers.Case3") {
    assert(MedianOf2SortedArrays.solution(Array(1,2), Array(3,5,6)) == 3.0)
  }
}
