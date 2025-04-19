package io.sid.countdown
package service

import scala.util.Random

object Generator {

  private val vowels: List[Char] = List('A', 'E', 'I', 'O', 'U')
  private val consonants: List[Char] = List('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R'
    , 'S', 'T', 'V', 'W', 'X', 'Y', 'Z');
  private val largeNumbers: List[Int] = List(25, 50, 75, 100)

  private val randomizer = new Random()

  val nextConsonant: () => Char = () => consonants(randomizer.nextInt(21))

  val nextVowels: () => Char = () => vowels(randomizer.nextInt(5))
  
  val nextLargeInt: () => Int = () => largeNumbers(randomizer.nextInt(4))
  
  val nextInt: () => Int = () => randomizer.nextInt(10) + 1
}