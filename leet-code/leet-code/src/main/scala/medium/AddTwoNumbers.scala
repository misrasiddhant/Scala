package medium

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */


// Definition for singly-linked list. 
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object AddTwoNumbers extends App {

  private def add(l1: ListNode, l2: ListNode, carryOver: Int = 0): ListNode = {
    val (x1, next1) = if (l1 == null) (0, null) else (l1.x, l1.next)
    val (x2, next2) = if (l2 == null) (0, null) else (l2.x, l2.next)
    val sum = x1 + x2 + carryOver
    val next = if (next1 != null || next2 != null) add(next1, next2, if (sum < 10) 0 else 1) else if (sum > 9) ListNode(1, null) else null
    ListNode(if (sum < 10) sum else sum - 10, next)
  }

  def solution(l1: ListNode, l2: ListNode): ListNode = {
    add(l1, l2)
  }
}
