import sbt._
import sbt.librarymanagement.Configurations.{IntegrationTest, Test}

object Dependencies {

  val unitTest = Seq(
    "org.scalactic" %% "scalactic" % Versions.scalactic % Test,
    "org.scalatest" %% "scalatest" % Versions.scalatest % Test
  )

  val util = Seq(
    ("com.github.pureconfig" %% "pureconfig" % Versions.pureconfig).cross(CrossVersion.for3Use2_13)
  )

  val http = Seq(
    ("org.scalaj" %% "scalaj-http" % Versions.scalajHttp).cross(CrossVersion.for3Use2_13)
  )

  val logging = Seq(
    "ch.qos.logback" % "logback-classic" % Versions.logback % Runtime
  )

  object Versions {
    val logback = "1.2.11"
    val scalactic = "3.2.11"
    val scalatest = "3.2.11"
    val logbackVersion = "1.2.10"
    val pureconfig = "0.17.1"
    val scalajHttp = "2.4.2"
  }
}