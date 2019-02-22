package models

import common.Utils._
import models.interface.{Formattable, Identifiable}
import play.api.libs.json._

import scala.collection.mutable.ListBuffer

class Territory(val name: String) extends Identifiable with Formattable {
  val adjacencyTerritories: ListBuffer[Territory] = ListBuffer()
  var owner: Player = _
  var armies = 0

  def border(territories: Territory*): Unit = {
    adjacencyTerritories ++= territories
  }

  override def format: JsValue = Json.obj(
    "id" -> JsString(id),
    "name" -> JsString(name),
    "adjacencyTerritories" -> toJson(onlyId(adjacencyTerritories)),
    "owner" -> JsString(owner.id),
    "armies" -> JsNumber(armies),
  )
}
