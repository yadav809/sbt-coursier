package repositories

import javax.inject.{Inject, Singleton}
import models.{Task, TaskTable}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.SQLiteProfile
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class TaskRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[SQLiteProfile]
  private val tasks = TaskTable.tasks

  def addTask(description: String): Future[Int] = {
    val task = Task(None, description)
    dbConfig.db.run(tasks returning tasks.map(_.id) += task)
  }

  def updateTask(id: Int, description: String): Future[Int] = {
    dbConfig.db.run(tasks.filter(_.id === id).map(_.description).update(description))
  }

  def deleteTask(id: Int): Future[Int] = {
    dbConfig.db.run(tasks.filter(_.id === id).delete)
  }

  def getAllTasks: Future[Seq[Task]] = {
    dbConfig.db.run(tasks.result)
  }
}
