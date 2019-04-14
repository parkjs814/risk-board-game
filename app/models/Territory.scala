package models

import models.interface.Identifiable

class Territory(val name: String) extends Identifiable {
  // TODO: there cannot be an empty territory. how to prevent?
  var adjacencyTerritories: List[Territory] = List()
  var owner: Option[Player] = None
  var armies: Int = 0

  def border(territories: Territory*): Unit = {
    adjacencyTerritories ++= territories
  }

  def reset(): Unit = {
    owner = None
    armies = 0
  }

  override def fields: Map[String, Any] = Map(
    "id" -> id,
    "name" -> name,
    "adjacencyTerritories" -> adjacencyTerritories,
    "owner" -> owner,
    "armies" -> armies
  )
}
