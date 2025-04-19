package io.sid.countdown
package service

import scala.collection.mutable
import scala.io.Source

class WordService {

  private var characterMap: mutable.Map[Char, mutable.Seq[String]] = mutable.Map()

  private def getUniqueLetters(word: String): Unit = {
      val letters = word.toList.distinct
      letters.foreach(c => {
        var items = characterMap.getOrElse(c, mutable.Seq())
        items = items :+ (word)
        println(items)
        characterMap.put(c, items)
      })
  }

  def loadWordList(): mutable.Map[Char, mutable.Seq[String]] = {
    val file = Source.fromFile("src/main/resources/data/wordlist.10000.txt")
    val wordList = file.getLines().toList
    println(wordList)
    for (word <- wordList) getUniqueLetters(word)
    characterMap
  }
}
