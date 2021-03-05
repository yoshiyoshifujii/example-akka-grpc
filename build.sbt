lazy val baseName = "example-akka-grpc"

lazy val root = (project in file(".")).
  settings(
    name := s"$baseName",
    organization := "com.github.yoshiyoshifujii",
    scalaVersion := "2.13.5",
    version      := "0.1"
  )
