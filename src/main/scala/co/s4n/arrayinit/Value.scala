package co.s4n.arrayinit

trait Value

case class ValInt(i:Int) extends Value
case class ValInit(lst:List[Value]) extends Value

object Value {
  def deep(value:Value):Int = value match {
    case ValInt(_)    => 0
    case ValInit(lst) => lst.map(deep(_) + 1).max 
  }
}
