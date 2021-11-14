package assignments.extra

import scala.collection.mutable

def rpn(input: String): Option[Float] =
  val numbers = mutable.Stack.from(input.split(' ')).foldLeft(mutable.Stack.empty[Float])(innerRpn)
  val result = numbers.pop()
  if !numbers.isEmpty then None else Some(result)

private def innerRpn(numbers: mutable.Stack[Float], op: String): mutable.Stack[Float] =
  op match
    case "+" | "-" | "*" | "/" | "^" =>
      val n1 = numbers.pop()
      val n2 = numbers.pop()
      op match
        case "+" => numbers.push(n2 + n1)
        case "-" => numbers.push(n2 - n1)
        case "*" => numbers.push(n2 * n1)
        case "/" => numbers.push(n2 / n1)
        case "^" => numbers.push(Math.pow(n2.toDouble, n1.toDouble).toFloat)
      numbers
    case "ln" =>
      val n1 = numbers.pop()
      numbers.push(Math.log(n1.toDouble).toFloat)
    case "log10" =>
      val n1 = numbers.pop()
      numbers.push(Math.log10(n1.toDouble).toFloat)
    case "sum" =>
      mutable.Stack(numbers.sum)
    case "prod" =>
      mutable.Stack(numbers.product)
    case _ =>
      numbers.push(op.toFloat)