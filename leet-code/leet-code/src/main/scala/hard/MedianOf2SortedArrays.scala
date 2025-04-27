package hard

import scala.collection.mutable.ArrayBuffer

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:

  Input: nums1 = [1,3], nums2 = [2]
  Output: 2.00000
  Explanation: merged array = [1,2,3] and median is 2.

Example 2:

  Input: nums1 = [1,2], nums2 = [3,4]
  Output: 2.50000
  Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:
  nums1.length == m
  nums2.length == n
  0 <= m <= 1000
  0 <= n <= 1000
  1 <= m + n <= 2000
  -106 <= nums1[i], nums2[i] <= 106
*/

object MedianOf2SortedArrays extends App{

  def solution(nums1: Array[Int], nums2: Array[Int]): Double = {
      val totalLength = nums1.length + nums2.length
      val medianIndexes = if (totalLength % 2 != 0) Array(totalLength/2) else Array((totalLength/2)-1, (totalLength/2))
      var (i,j) = (0,0)
      var sum = 0
      while(i+j <= medianIndexes.max){
        val maxVal = (i, j) match
          case (x, y) if x < nums1.length && y >= nums2.length =>
            i+=1
            nums1(x)
          case (x, y) if x >= nums1.length && y < nums2.length =>
            j+=1
            nums2(y)
          case (x, y) if nums1(x) <= nums2(y) =>
            i+=1
            nums1(x)
          case (x, y) if nums1(x) > nums2(y) =>
            j+=1
            nums2(y)

        sum = sum + (if medianIndexes.contains(i + j - 1) then maxVal else 0)
      }
      sum.toFloat / medianIndexes.length
  }
}
