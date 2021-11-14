package assignments.kex2

import shared.{Player, PLAYER_INITIAL_HP, PLAYER_DEFENSE}

case class Kex2()

object Kex2:
  def run(): Unit =
    println("冒険が今始まる！")
    val player = Player(PLAYER_INITIAL_HP, PLAYER_DEFENSE)
    println(gameLoop(player))