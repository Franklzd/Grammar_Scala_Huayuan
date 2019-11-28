package com.Leizedeng.scala.Grammar2

/**
 * Created by Administrator on 2019/11/27.
 * 1. Trait : 相当于Java中的接口
 *    1.1 scala中不论继承一个类还是一个Trait，都用extends
 *    1.2 当继承一个Trait，需要实现该Trait中的所以方法，但是不用使用overwrite
 *    1.3 scala与java一样，不允许多继承，但是scala中可以用多实现，关键词为 with
 *      类型 class extend class with trait with trait
 *      class extend trait with trait with trait
 * 2. 模式匹配
 *
 * 3. 异常处理
 *
 */
object TryCatchObject {

  def main(args: Array[String]) {
    try{
      val result = 1 / "xx".toInt
    }catch{
      case e : ArithmeticException => throw new RuntimeException("*****")
      case e : Exception => e.printStackTrace()

    }finally {
      println("____________end___________")
    }

    val map = Map("k1"->18,"k2"->20)
//    map.getOrElse()

  }
}
