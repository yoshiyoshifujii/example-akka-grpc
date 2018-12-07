import Dependencies._

lazy val root = (project in file(".")).
  enablePlugins(AkkaGrpcPlugin).
  enablePlugins(JavaAgent).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "example-akka-grpc",
    libraryDependencies += scalaTest % Test,
    javaAgents += "org.mortbay.jetty.alpn" % "jetty-alpn-agent" % "2.0.9" % "runtime;test"
  )
