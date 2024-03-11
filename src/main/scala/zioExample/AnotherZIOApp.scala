package zioExample

import zio.{ExitCode, ZIO}
import zioExample.Schema._
import zioExample.service.Service
//import zioExample.fsService.GCSFS
//import zioExample.fsService.LocalFS
import zioExample.dbService.BQ
//import zioExample.dbService.SQLLite

object AnotherZIOApp extends zio.App {

  val program = for {
    _ <- ZIO.service[Service].flatMap(s=>s.write(List(user1)))
    _ <- ZIO.service[Service].flatMap(s=>s.read(""))
  } yield ()

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, ExitCode] = {
      program.provideLayer(BQ.live)
      .exitCode
  }
}