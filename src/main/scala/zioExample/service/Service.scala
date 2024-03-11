package zioExample.service

import zio.Task
import zioExample.Schema.User

trait Service {

  def write(user: List[User]): Task[Unit]

  def read(user_table: String): Task[List[User]]

}
