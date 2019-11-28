package com.Leizedeng.scala.Grammar

/**
 * Created by Administrator on 2019/11/27.
 *
 * 介绍class与object
 */
/*
  1.修饰符
    1.1 public ：默认，不能直接使用
    1.2 protected：不用
    1.3 private[this]
    1.4 private[field=package]
  2.class
    2.1 一个scala文件中可以定义多个class
    2.2 当被static修饰的，建议通过Class.var
    2.3 在scala中，会为每个参数定义get和set方法
 */

/*
  在一个文件中，当class 名称和 Object名称 相同时，
  则该class 是该object 的伴生类，而该object是该class的伴生对象
  特点：
    1. 双方可互相访问私有属性的值（private）
    2. 在伴生对象中可以重载多个apply方法，通过调用apply来构造伴生类
      2.1 apply方法不是构造函数
      2.2 apply方法还是会调用实际的构造方法
//      2.3 apply方法中的第一行必须调用构造方法
      2.4 apply实现的功能，实例化对象的时候可以不用new class，直接使用class的方式
      2.5 apply，根据参数的不同，可以重载多个
      2.6 必需要有返回值
 */

class ScalaPersonMain{
  var name:String = _
  private val age = "20"
  def func1(): Unit ={
    println("this is a function"+ScalaPersonMain.age2)
  }
}

object ScalaPersonMain {
  private val age2 = "50"

  def func2(): Unit ={
    println("my actual age :"+new ScalaPersonMain().age)
  }

  def apply()  = new ScalaPersonMain()

  def apply(name:String):ScalaPersonMain = {
    val p3  = new ScalaPersonMain()
    p3.name = name
    p3
  }

  def main (args: Array[String]) {

    val person = new Person01()
    println(person.name)
    person.eat()
    person.watchTV("Frank")
    person.sayHello("Rorn")
  }

}
