package com.Leizedeng.scala.Grammar2

/**
 * Created by Administrator on 2019/11/27.
 *
 * 1.为了避免scala中的程序出错，引入了Option类型
 * 值
 *  some(value):表示有值，并且在some中
 *  none ：表示没有值
 *  val map = Map("key1"->18)
 *  map.get("key1") match{
 *    case Some(v) => println(v)
 *    case None => println(.......)
 *  }
 *  2. 隐式转换
 *  关键词：implicit
 *    修饰方法，参数，属性
 *    作用域：1. 当前类中定义
 *            2. 使用import导入
 *            3. 源类型或者目标类型的伴生对象中
 *     最好返回类型
 *     隐式转换调用过一次，后面该类将不需要隐式转换了
 *
 */

class Man(val name:String){}

class SuperMan(val name:String){
  def fly = print(name+" can fly ....")
}
object ImplicitClass {
  implicit  def manToSuperMan(man:Man):SuperMan={
    new SuperMan(man.name)
  }
  def main(args: Array[String]) {
    val man = new Man("woodz")
    man.fly  //隐式转换

    val map = Map("key1"->18)
    map.get("key1") match{
       case Some(v) => println(v)
       case None => println(".......")
      }
  }
}
