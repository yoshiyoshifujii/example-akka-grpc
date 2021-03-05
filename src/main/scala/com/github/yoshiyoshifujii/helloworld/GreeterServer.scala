package com.github.yoshiyoshifujii.helloworld

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import com.github.yoshiyoshifujii.helloworld.grpc.{ GreeterServiceHandler, GreeterServiceImpl }

import scala.concurrent.{ ExecutionContext, Future }

object GreeterServer extends App {

  private val system = ActorSystem("HelloWorld")

  private def run(implicit system: ActorSystem): Future[Http.ServerBinding] = {
    implicit val ec: ExecutionContext = system.dispatcher

    val service = GreeterServiceHandler(new GreeterServiceImpl())
    val binding = Http().newServerAt("127.0.0.1", 8080).bind(service)
    binding.foreach(b => println(s"gRPC server bound to: ${b.localAddress}"))

    binding
  }

  run(system)

}
