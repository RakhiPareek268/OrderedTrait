package edu.knoldus
import org.scalatest.flatspec.AnyFlatSpec

//case class number(element:Int) extends Ordered[number]{
//  def compare(that: number): Int =
//    if (this.element < that.element) -1
//    else if (this.element > that.element) 1
//    else 0
//}

class SetTest extends AnyFlatSpec{
  var obj=new EmptySet[number]
  var obj1=new NonEmptySet[number](number(5),obj.incl(number(4)),obj.incl(number(1)))

  "Condition" should "include element in EmptySet using incl method" in {
    val st1= obj.incl(number(4)).incl(number(3))
    assert(st1.contains(number(4)))
  }
  "condition" should "check weather the element is present inthe set tree or not " in {
    val st2 = obj.incl(number(1)).incl(number(0)).incl(number(8)).incl(number(5))
    assert(st2.contains(number(0)))
    assert(!st2.contains(number(10)))
  }
  "condition" should "check weather non empty set has value 5 "in{
    assert(obj1.contains(number(5)))
  }



}

