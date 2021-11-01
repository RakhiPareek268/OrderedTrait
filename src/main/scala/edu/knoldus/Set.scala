package edu.knoldus
trait Set[A <: Ordered[A]] {
  def incl(element: A): Set[A]
  def contains(value: A): Boolean
  abstract class SetTree
}
class EmptySet[A<:Ordered[A]] extends Set[A]{
  def incl(element: A): Set[A] =new NonEmptySet(element, new EmptySet[A], new EmptySet[A])
  def contains(value: A): Boolean =false
}
class NonEmptySet[A<:Ordered[A]](element:A,left:Set[A],right:Set[A])extends Set[A] {
  def contains(value: A): Boolean = if (value < element) left contains (value)
  else if (value > element) right contains (value)
  else (value == element)
  true

  def incl(value: A): Set[A] = {
    if (value < element) new NonEmptySet(element, left incl (value), right)
    else if (value > element) new NonEmptySet(element, left, right incl (value))
    else this
  }
}


case class number(element:Int) extends Ordered[number]{
  def compare(that: number): Int =
    if (this.element < that.element) -1
    else if (this.element > that.element) 1
    else 0
}

//object main {
//  def main(args: Array[String]): Unit = {
//    var obj = new EmptySet[number].incl(number(1)).incl(number(2))
//    print(obj.contains(number(2)))
//  }
//}

