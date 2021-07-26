package co.s4n.arrayinit

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._
import co.s4n.arrayinit.parser._
import scala.jdk.CollectionConverters._
import scala.collection.mutable.Buffer

class ImplVisitor extends ArrayInitBaseVisitor[Value] {
  override def visitInit(ctx:ArrayInitParser.InitContext):Value = {
    var buffer:Buffer[ArrayInitParser.ValueContext] =
      ctx.value().asScala
    var buffer2:Buffer[Value] = buffer.map(visit(_))
    ValInit(buffer2.toList)
  }

  override def visitArray(ctx:ArrayInitParser.ArrayContext):Value = {
    visit(ctx.init())
  }

  override def visitInteger(ctx:ArrayInitParser.IntegerContext):Value = {
    ValInt(ctx.INT().getText().toInt)
  }
}
