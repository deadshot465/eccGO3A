package assignments.musicians

import java.util.concurrent.LinkedTransferQueue
import scala.util.Random

enum SkillLevel:
  case Good
  case Bad

case class Musician(role: String, skillLevel: SkillLevel, fireQueue: LinkedTransferQueue[Integer]):
  private val name = Musician.pickName()
  println(s"Musician $name, playing the $role entered the room.")

  def playSound(): Boolean =
    val isFired = fireQueue.poll()
    if isFired != null then
      println(s"$name just got back to playing in the subway.")
      false
    else
      skillLevel match
        case SkillLevel.Good =>
          println(s"$name produced sound!")
          true
        case SkillLevel.Bad =>
          val failed = Random.between(0, 5) == 0
          if failed then
            println(s"$name played a false note. Uh oh.")
            println(s"$name sucks! kicked that member out of the band! ($role)")
            false
          else
            println(s"$name produced sound!")
            true

object Musician:
  val delay = 750
  
  private val firstNames = Seq("Valerie", "Arnold", "Carlos", "Dorothy", "Keesha",
    "Phoebe", "Ralphie", "Tim", "Wanda", "Janet",
    "Leo", "Yuhei", "Carson")

  private val lastNames = Seq("Frizzle", "Perlstein", "Ramon", "Ann", "Franklin",
    "Terese", "Tennelli", "Jamal", "Li", "Perlstein",
    "Fujioka", "Ito", "Hage")

  private def pickName(): String =
    val firstName = firstNames(Random.between(0, firstNames.length))
    val lastName = lastNames(Random.between(0, lastNames.length))
    s"$firstName $lastName"