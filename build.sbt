name := """nyoba-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  // http://mvnrepository.com/artifact/org.postgresql/postgresql
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.flywaydb" %% "flyway-play" % "3.0.0"

)
