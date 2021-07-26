package co.s4n.arrayinit

import co.s4n.arrayinit.parser._
import scala.util.parsing.combinator._
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._
import co.s4n.arrayinit.parser._

object GetArrayInit extends App {

  def getArrayInit(str:String) =
    InitArrayPC.init(new InitArrayPC.lexical.Scanner(str))

  def getArrayInitAntlr4(str:String):Value = {
    val input = CharStreams.fromString(str)
    val lexer = new ArrayInitLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new ArrayInitParser(tokens)
    val tree = parser.init()
    val vis = new ImplVisitor()
    vis.visit(tree)
  }

}
