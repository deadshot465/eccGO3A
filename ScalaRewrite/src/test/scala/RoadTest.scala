import assignments.extra.{PathItem, runRoadAnalysis}
import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable.ArrayBuffer

class RoadTest extends AnyFlatSpec:
  "runRoadAnalysis" should "be equal to expected road" in {
    val expectedRoad = ArrayBuffer(
      PathItem('b', 10),
      PathItem('x', 30),
      PathItem('a', 5),
      PathItem('x', 20),
      PathItem('b', 2),
      PathItem('b', 8)
    )
    val runResult = runRoadAnalysis()
    assert(runResult == expectedRoad)
  }