package medium

import org.scalatest.funsuite.AnyFunSuite

class LongestSubstringWithoutRepeatingCharTest extends AnyFunSuite {
  test("LongestSubstringWithoutRepeatingChar.Case1") {
    assert(LongestSubstringWithoutRepeatingChar.solution(" ") == 1)
  }

  test("LongestSubstringWithoutRepeatingChar.Case2") {
    assert(LongestSubstringWithoutRepeatingChar.solution("pwwkew") == 3)
  }

  test("LongestSubstringWithoutRepeatingChar.Case3") {
    assert(LongestSubstringWithoutRepeatingChar.solution("bbbb") == 1)
  }

  test("LongestSubstringWithoutRepeatingChar.Case4") {
    assert(LongestSubstringWithoutRepeatingChar.solution("abcabcbb") == 3)
  }

  test("LongestSubstringWithoutRepeatingChar.Case5") {
    assert(LongestSubstringWithoutRepeatingChar.solution("cdd") == 2)
  }

  test("LongestSubstringWithoutRepeatingChar.Case6") {
    assert(LongestSubstringWithoutRepeatingChar.solution("pacvypxdmqxevpbsucieitc") == 12)
  }

  test("LongestSubstringWithoutRepeatingChar.Case7") {
    assert(LongestSubstringWithoutRepeatingChar.solution("au") == 2)
  }

  test("LongestSubstringWithoutRepeatingChar.Case8") {
    assert(LongestSubstringWithoutRepeatingChar.solution("aabaab!bb") == 3)
  }
}
