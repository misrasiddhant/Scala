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

        val wordMapItems = wordMap.get(key) match
          case Some(value) => value :+ (word)
          case None => {
            key.foreach(c => {

              val items = characterMap.get(c) match
                case Some(value) => value :+ key
                case None => mutable.Seq(key)

              characterMap.put(c, items)
            })
            mutable.Seq(word)
          }
        wordMap.put(key, wordMapItems)
    }
    (characterMap, wordMap)
  }

  private val (_characterMap, _wordMap) = loadWordList()

  def characterMap: mutable.Map[Char, mutable.Seq[String]] = _characterMap
  def wordMap: mutable.Map[String, mutable.Seq[String]] = _wordMap

  def solve(input: String): String = {
    val inputKey = getKey(input)
    val eligibleKeys = inputKey.toList.map(c =>
      _characterMap.getOrElse(c, mutable.Seq())
    ).flatMap(_.toList).distinct.filter(key => key.forall(inputKey.contains))

    val inputCharFrequency = input.foldLeft(Map[Char, Int]().withDefaultValue(0)) {
      (map, c) => map.updated(c, map(c) + 1)
    }

    var largestWord = ""
    eligibleKeys.foreach( key =>
      _wordMap.getOrElse(key,Seq())
      .filter(key => {
        val keyCharFrequency = key.foldLeft(Map[Char, Int]().withDefaultValue(0)) {
          (map, c) => map.updated(c, map(c) + 1)
        }
        keyCharFrequency.forall((c,f) => inputCharFrequency.getOrElse(c,0) >= f)
      })
      .foreach(
        word =>
          largestWord= if (word.length > largestWord.length) word else largestWord
      )
    )
    largestWord
  }
}
