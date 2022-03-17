lazy val root = (project in file("."))
  .settings(
    name := "recruitment-task-for-atlassian",
    idePackagePrefix := Some("org.atlassian")
  )

ThisBuild / version := "0.0.1-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

libraryDependencies ++= Dependencies.util
libraryDependencies ++= Dependencies.logging
libraryDependencies ++= Dependencies.unitTest

scalacOptions ++= Seq(
  "-encoding", "UTF-8", // Specify character encoding used by source files.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-explaintypes", // Explain type errors in more detail.
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
  "-language:higherKinds", // Allow higher-kinded types
  "-language:implicitConversions" // Allow definition of implicit functions called views
)