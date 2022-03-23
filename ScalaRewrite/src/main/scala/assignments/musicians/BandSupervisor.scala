package assignments.musicians

import java.util.concurrent.LinkedTransferQueue
import scala.annotation.tailrec
import scala.util.control.Breaks

object BandSupervisor:
  def startBand(maxRetries: Int): Unit =
    val members = collection.mutable.HashMap.empty[String, LinkedTransferQueue[Integer]]
    val queue = LinkedTransferQueue[(String, SkillLevel)]
    members("singer") = addBandMember("singer", SkillLevel.Good, queue)
    members("bass") = addBandMember("bass", SkillLevel.Good, queue)
    members("drum") = addBandMember("drum", SkillLevel.Bad, queue)
    members("guitar") = addBandMember("guitar", SkillLevel.Good, queue)
    loop(maxRetries, queue, members)

  @tailrec
  private def loop(retries: Int, queue: LinkedTransferQueue[(String, SkillLevel)], members: collection.mutable.HashMap[String, LinkedTransferQueue[Integer]]): Unit =
    if retries <= 0 then
      println("The manager is mad and fired the whole band!")
      members.foreach { member => member._2.offer(0) }
      Thread.sleep(3000)
    else
      val (role, skillLevel) = queue.take()
      members.remove(role)
      members(role) = addBandMember(role, skillLevel, queue)
      loop(retries - 1, queue, members)

  @tailrec
  private def playSound(role: String, skillLevel: SkillLevel, musician: Musician, queue: LinkedTransferQueue[(String, SkillLevel)]): Unit =
    Thread.sleep(Musician.delay)
    val playResult = musician.playSound()
    if !playResult then
      queue.offer((role, skillLevel))
    else
      playSound(role, skillLevel, musician, queue)

  private def addBandMember(role: String, skillLevel: SkillLevel, queue: LinkedTransferQueue[(String, SkillLevel)]): LinkedTransferQueue[Integer] =
    val fireQueue = LinkedTransferQueue[Integer]()
    val musician = Musician(role, skillLevel, fireQueue)
    val thread = Thread(() => {
      playSound(role, skillLevel, musician, queue)
    })
    thread.start()
    fireQueue