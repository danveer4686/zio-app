package zioExample.fsService

import zio.{Has, Task, ZIO, ZLayer}
import zioExample.Schema._
import zioExample.service.Service

object LocalFS {

  // layer - service implementation
  val live: ZLayer[Any, Nothing, Has[Service]] = ZLayer.succeed {
    new Service  {
      override def write(user: List[User]): Task[Unit] = Task {
        println(s"writing data on local path: ")
      }

      override def read(local_csv_path: String): Task[List[User]] = Task {
        println(s"reading data from local path: ")
        List(user1, user2, user3, user4, user5, user6)
      }
    }
  }

  // accessor
//  def write(users: List[User]): ZIO[Has[LocalFS.LocalService], Throwable, Unit] = ZIO.accessM(_.get.write(users))
//
//  def read(path: String): ZIO[Has[LocalFS.LocalService], Throwable, List[User]] = ZIO.accessM(_.get.read(path))

}
