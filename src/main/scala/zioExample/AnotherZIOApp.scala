package zioExample

import zio.{ExitCode, ZIO}
import zioExample.Schema._
import zioExample.fsService.GCSFS._
//import zioExample.fsService.LocalFS._
//import zioExample.dbService.BQ._
//import zioExample.dbService.SQLLite._

object AnotherZIOApp extends zio.App {

  val program = for {
    _ <- write(List(user1,user2,user3,user4,user5,user6))
    _ <- read("")
  } yield ()

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, ExitCode] = {
      program.provideLayer(live)
      .exitCode
  }
}