package example.myapp.helloworld

import akka.NotUsed
import akka.stream.Materializer
import akka.stream.scaladsl.Source
import example.myapp.helloworld.grpc.{Greeter, HelloReply, HelloRequest, RepeatHelloRequest}

import scala.concurrent.Future

class GreeterServiceImpl(materializer: Materializer) extends Greeter {
  private implicit val mat: Materializer = materializer

  override def sayHello(in: HelloRequest): Future[HelloReply] = {
    println(s"sayHello to ${in.name}")
    Future.successful(HelloReply(s"Hello, ${in.name}"))
  }

  override def sayRepeatHello(in: RepeatHelloRequest): Source[HelloReply, NotUsed] = {
    println(s"sayRepeatHello to ${in.name}")
    Source(s"Hello, ${in.name}".toList)
      .map(character => HelloReply(character.toString))
  }

  override def sayHelloAfterDelay(in: HelloRequest): Future[HelloReply] = {
    println(s"sayHelloAfterDelay to ${in.name}")
    Future.successful(HelloReply(s"Hello, ${in.name}"))
  }
}
