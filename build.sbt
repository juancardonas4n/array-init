import Dependencies._

ThisBuild / scalaVersion     := "2.13.6"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "co.s4n"
ThisBuild / organizationName := "s4n"

lazy val root = (project in file("."))
  .settings(
    name := "array-init",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.0.0"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
enablePlugins(Antlr4Plugin)

Antlr4 / antlr4Version  := "4.9.2"
Antlr4 / antlr4GenVisitor  := true
Antlr4 / antlr4GenListener := false
