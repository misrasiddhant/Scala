package io.sid.countdown
package service

import scala.collection.mutable
import scala.io.Source

class WordService {

  private def getKey(word: String) = word.toList.distinct.sorted.mkString

  private def loadWordList() = {
    val characterMap: mutable.Map[Char, mutable.Seq[String]] = mutable.Map()
    val wordMap: mutable.Map[String, mutable.Seq[String]] = mutable.Map()
    val file = Source.fromFile("src/main/resources/data/wordlist.10000.txt")
    val wordList = file.getLines().toList
    wordList.foreach {
      word =>
        val key = getKey(word)
        var wordMapItems = wordMap.getOrElse(key, mutable.Seq())
        wordMapItems = wordMapItems :+ (word)
        wordMap.put(key, wordMapItems)
        key.foreach(c => {
          var items = characterMap.getOrElse(c, mutable.Seq())
          items = items :+ (word)
          characterMap.put(c, items)
        })

    }
    (characterMap, wordMap)
  }

  private val (_characterMap, _wordMap) = loadWordList()

  def characterMap: mutable.Map[Char, mutable.Seq[String]] = _characterMap
  def wordMap: mutable.Map[String, mutable.Seq[String]] = _wordMap
}
