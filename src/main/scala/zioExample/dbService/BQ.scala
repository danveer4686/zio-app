package zioExample.dbService

import zio.{Has, Task, ZIO, ZLayer}
import zioExample.Schema._
import zioExample.service.Service

object BQ {

  // layer - service implementation
  val live: ZLayer[Any, Nothing, Has[Service]] = ZLayer.succeed {
    new Service {
      override def write(user: List[User]): Task[Unit] = Task {
        println(s"writing data in bq db: ")
      }

      override def read(user_table: String): Task[List[User]] = Task {
        println(s"reading data from bq table ")
        List(user1, user2, user3, user4, user5, user6)
      }
    }
  }

  // accessor
//  def write(users: List[User]): ZIO[Has[BQ.BQService], Throwable, Unit] = ZIO.accessM(_.get.write(users))
//
//  def read(path: String): ZIO[Has[BQ.BQService], Throwable, List[User]] = ZIO.accessM(_.get.read(path))

}
