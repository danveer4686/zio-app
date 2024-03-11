package zioExample.dbService

import zio.{Has, Task, ZIO, ZLayer}
import zioExample.Schema._
import zioExample.service.Service

object SQLLite {

  // layer - service implementation
  val live: ZLayer[Any, Nothing, Has[Service]] = ZLayer.succeed {
    new Service {
      override def write(user: List[User]): Task[Unit] = Task {
        println(s"writing data in sqllite table: ")
      }

      override def read(user_table: String): Task[List[User]] = Task {
        println(s"reading data from sqllite table ")
        List(user1, user2, user3, user4, user5, user6)
      }
    }
  }

  // accessor
//  def write(users: List[User]): ZIO[Has[SQLLite.SQLLiteService], Throwable, Unit] = ZIO.accessM(_.get.write(users))
//
//  def read(path: String): ZIO[Has[SQLLite.SQLLiteService], Throwable, List[User]] = ZIO.accessM(_.get.read(path))

}
