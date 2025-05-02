package com.github.misrasiddhant.streaming.demo.producer

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import java.util.Properties


object EventGenerator extends App {
  private val property = Properties()
  property.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092")
  property.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
  property.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

  val producer = KafkaProducer[String, String](property)

  val topic = "si"
  val record = new ProducerRecord[String, String](topic, "key", "Hello Kafka from Scala 2")
  for(_ <- 1 to 10) producer.send(record)
  producer.close()
  // kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic si --from-beginning
}
