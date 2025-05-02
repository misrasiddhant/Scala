ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

resolvers += "confluent" at "https://packages.confluent.io/maven/"

val commonDependencies = Seq(
  "org.apache.kafka" % "kafka-clients" % "7.9.0-ce",
  "io.confluent" % "kafka-avro-serializer" % "7.9.0"
)

lazy val consumer = (project in file("./kafka/consumer"))
  .settings(
    name := "flink-kafka-consumer"
  )

lazy val producer = (project in file("./kafka/producer"))
  .settings(
    name := "kafka-producer",
    resolvers += "confluent" at "https://packages.confluent.io/maven/",
    libraryDependencies ++= commonDependencies,
  )
