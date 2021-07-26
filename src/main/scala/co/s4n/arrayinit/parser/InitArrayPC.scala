package co.s4n.arrayinit.parser

import co.s4n.arrayinit._
import scala.util.parsing.combinator._
import scala.util.parsing.combinator.lexical._
import scala.util.parsing.combinator.syntactical._

object InitArrayPC extends StdTokenParsers {
  type Tokens = StdLexical
  val lexical = new StdLexical
  lexical.delimiters ++= List("{","}",",")

  lazy val init:Parser[Value]  = "{"~>(value~rep("," ~> value)) <~ "}" ^^ {case v~lst => ValInit(v+:lst) }
  lazy val value:Parser[Value] = numericLit ^^ { i => ValInt(i.toInt) } | init
}
