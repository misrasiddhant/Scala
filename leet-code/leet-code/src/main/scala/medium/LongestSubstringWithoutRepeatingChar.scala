package medium

import scala.collection.mutable

/*
3. Longest Substring Without Repeating Characters
    Given a string s, find the length of the longest substring without duplicate characters.
    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

object LongestSubstringWithoutRepeatingChar extends App {

  private val multiCharSet = (s: String) => s.groupBy(identity).filter((c, group) => group.length > 1).keys

  // ToDo: use trailrec
  private def check(s: String, l: Int): Int = {
    val flag = (0 until (s.length - l + 1)).collectFirst {
      case index if multiCharSet(s.substring(index, l + index)).isEmpty => true
    }
    if flag.isDefined then l else check(s, l - 1)
  }

  private def linearParse(s: String): Int = {
    var buffer: mutable.Seq[Char] = mutable.Seq()
    var longestLength = 0
    var length = 0
    s.foreach(c =>
      val index = buffer.indexOf(c, 0)
      if index >= 0 then {
        longestLength = if length > longestLength then length else longestLength
        buffer = buffer.takeRight(length - index - 1) :+ c
        length = buffer.length
      } else {
        buffer = buffer :+ c
        length += 1
      }
    )
    if length > longestLength then length else longestLength
  }

  def solution(s: String): Int = {
    //    val distinctChars = s.distinct.length
    //    if (distinctChars < 2) distinctChars else check(s, distinctChars)
    linearParse(s)
  }
}
