package zioExample

import zio.{Has, Task, ZIO, ZLayer}
import zioExample.Schema._

object GCSFS {

  // service definition
  trait GCSService {
    def write(user: List[User]): Task[Unit]

    def read(gcs_csv_path: String): Task[List[User]]
  }

  // layer - service implementation
  val live: ZLayer[Any, Nothing, Has[GCSFS.GCSService]] = ZLayer.succeed {
    new GCSService {
      override def write(user: List[User]): Task[Unit] = Task {
        println(s"writing data on GCS path: ")
      }

      override def read(local_csv_path: String): Task[List[User]] = Task {
        println(s"reading data from GCS path: ")
        List(user1, user2, user3, user4, user5, user6)
      }
    }
  }

  // accessor
  def write(users: List[User]): ZIO[Has[GCSFS.GCSService], Throwable, Unit] = ZIO.accessM(_.get.write(users))

  def read(path: String): ZIO[Has[GCSFS.GCSService], Throwable, List[User]] = ZIO.accessM(_.get.read(path))

}
