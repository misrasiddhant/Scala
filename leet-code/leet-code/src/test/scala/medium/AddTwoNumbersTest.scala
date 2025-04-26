package medium

import org.scalatest.funsuite.AnyFunSuite

class AddTwoNumbersTest extends AnyFunSuite{

  def getNodeList(seq: Seq[Int]): ListNode = {
      var firstNode: ListNode = null
      var previousNode: ListNode = null
      seq.foreach( n => {
          val node = ListNode(n, null)
          if(previousNode != null) previousNode.next = node
          if(firstNode == null) firstNode = previousNode
          previousNode = node
        }
      )
      firstNode
  }

  def validateSolution(solution: ListNode, testSeq: Seq[Int]): Boolean = {
    if solution == null then if testSeq.isEmpty then true else false
    else if solution.x == testSeq.head then validateSolution(solution.next, testSeq.drop(1))
    else false
  }

  test("AddTwoNumbers.Case1"){
    val l1 = getNodeList(Seq(2,4,3))
    val l2 = getNodeList(Seq(5,6,4))
    val solution  = AddTwoNumbers.solution(l1 = l1, l2 = l2)
    assert(validateSolution(solution, Seq(7,0,8)))
  }
  test("AddTwoNumbers.Case2") {
    val l1 = getNodeList(Seq(0))
    val l2 = getNodeList(Seq(0))
    val solution = AddTwoNumbers.solution(l1 = l1, l2 = l2)
    assert(validateSolution(solution, Seq(0)))
  }
  test("AddTwoNumbers.Case3") {
    val l1 = getNodeList(Seq(9,9,9,9,9,9,9))
    val l2 = getNodeList(Seq(9,9,9,9))
    val solution = AddTwoNumbers.solution(l1 = l1, l2 = l2)
    assert(validateSolution(solution, Seq(8,9,9,9,0,0,0,1)))
  }
}
