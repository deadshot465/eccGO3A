package assignments.extra

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

case class PathItem(name: Char, cost: Int) extends Comparable[PathItem]:
  override def compareTo(o: PathItem): Int =
    cost.compareTo(o.cost)

case class Route(destination: Int, path: mutable.ArrayBuffer[PathItem]) extends Comparable[Route]:
  override def compareTo(o: Route): Int =
    val destinationCompareResult = destination.compareTo(o.destination)
    if destinationCompareResult != 0 then
      destinationCompareResult
    else
      val zipped = path.zip(o.path)
      for
        item <- zipped
      do
        val result = item._1.compareTo(item._2)
        if result != 0 then
          return result
      path.lengthCompare(o.path)

case class RoutingResult(a: Route, b: Route)

def runRoadAnalysis(): mutable.ArrayBuffer[PathItem] =
  val content = Files.readString(Path.of("assets/road.txt"), Charset.forName("utf-8"))
  val parsedMap = parseMap(content)
  val groupedValues = groupValues(parsedMap)
  optimalPath(groupedValues)

private def parseMap(content: String): mutable.ArrayDeque[Int] =
  val split = content
    .split(Array(' ', '\n', '\t', '\r'))
    .map(s => s.trim)
    .filter(s => !s.isEmpty && s.length > 0)
    .map(s => s.toInt)
  mutable.ArrayDeque.from(split)

private def groupValues(numbers: mutable.ArrayDeque[Int]): mutable.ArrayDeque[(Int, Int, Int)] =
  val result = mutable.ArrayDeque.empty[(Int, Int, Int)]
  val numbersToMove = numbers
  while (!numbersToMove.isEmpty) do
    val a = numbersToMove.removeHeadOption().getOrElse(0)
    val b = numbersToMove.removeHeadOption().getOrElse(0)
    val x = numbersToMove.removeHeadOption().getOrElse(0)
    result += ((a, b, x))
  result

private def shortestSteps(acc: RoutingResult, elem: (Int, Int, Int)): RoutingResult =
  val ((a, b, x)) = elem
  val pathA1 = acc.a.path.clone()
  pathA1 += PathItem('a', a)
  val optA1 = Route(acc.a.destination + a, pathA1)

  val pathA2 = acc.b.path.clone()
  pathA2 += PathItem('b', b)
  pathA2 += PathItem('x', x)
  val optA2 = Route(acc.b.destination + b + x, pathA2)

  val pathB1 = acc.b.path.clone()
  pathB1 += PathItem('b', b)
  val optB1 = Route(acc.b.destination + b, pathB1)

  val pathB2 = acc.a.path.clone()
  pathB2 += PathItem('a', a)
  pathB2 += PathItem('x', x)
  val optB2 = Route(acc.a.destination + a + x, pathB2)

  RoutingResult(if optA1.compareTo(optA2) < 0 then optA1 else optA2,
    if optB1.compareTo(optB2) < 0 then optB1 else optB2)

private def optimalPath(values: mutable.ArrayDeque[(Int, Int, Int)]): mutable.ArrayBuffer[PathItem] =
  val initialResult = RoutingResult(Route(0, ArrayBuffer.empty[PathItem]), Route(0, ArrayBuffer.empty[PathItem]))
  val result = values.foldLeft(initialResult)(shortestSteps)
  if result.a.path.last != PathItem('x', 0) then
    result.a.path
  else if result.b.path.last != PathItem('x', 0) then
    result.b.path
  else
    ArrayBuffer.empty