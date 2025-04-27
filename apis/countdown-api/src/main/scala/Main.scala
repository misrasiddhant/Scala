package io.sid.countdown

import service.{Generator, WordService}

object Main extends App{
  println("We love Scala!!! don't we??")
  for (n <- 1 to 30) print(Generator.nextVowels())
  println()
  for (n <- 1 to 30) print(Generator.nextConsonant())
  println()
  for (n <- 1 to 30) print(Generator.nextLargeInt() + " ")
  println()
  for (n <- 1 to 30) print(Generator.nextInt() + " ")
  println()
  private val wordService = new WordService()
  println(wordService.solve("hrebaftnl"))

}
