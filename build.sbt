name := """E-commerce"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "com.googlecode.json-simple" % "json-simple" % "1.1.1",
  "org.apache.httpcomponents" % "httpclient" % "4.3.1",
  "com.google.code.gson" % "gson" % "2.3.1",
  "log4j" % "log4j" % "1.2.17"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
