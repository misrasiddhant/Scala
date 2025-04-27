package medium

import org.scalatest.funsuite.AnyFunSuite

class LongestSubstringWithoutRepeatingCharTest extends AnyFunSuite {
  test("AddTwoNumbers.Case1") {
    assert(LongestSubstringWithoutRepeatingChar.solution(" ") == 1)
  }

  test("AddTwoNumbers.Case2") {
    assert(LongestSubstringWithoutRepeatingChar.solution("pwwkew") == 3)
  }

  test("AddTwoNumbers.Case3") {
    assert(LongestSubstringWithoutRepeatingChar.solution("bbbb") == 1)
  }

  test("AddTwoNumbers.Case4") {
    assert(LongestSubstringWithoutRepeatingChar.solution("abcabcbb") == 3)
  }

  test("AddTwoNumbers.Case5") {
    assert(LongestSubstringWithoutRepeatingChar.solution("cdd") == 2)
  }

  test("AddTwoNumbers.Case6") {
    assert(LongestSubstringWithoutRepeatingChar.solution("pacvypxdmqxevpbsucieitc") == 12)
  }

  test("AddTwoNumbers.Case7") {
    assert(LongestSubstringWithoutRepeatingChar.solution("au") == 2)
  }

  test("AddTwoNumbers.Case8") {
    assert(LongestSubstringWithoutRepeatingChar.solution("aabaab!bb") == 3)
  }
}
