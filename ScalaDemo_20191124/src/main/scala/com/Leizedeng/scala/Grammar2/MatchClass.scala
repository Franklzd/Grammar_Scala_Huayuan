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
 *    2.1 支持匹配：类型，值，集合的元素，case class ，属性，是否有值等
 *    语法：
 *      变量 match { case 值 => code }
 *      match case 默认从上往下执行
 *      当条件匹配成功，后面的代码不再继续执行，自动跳出
 *      没有default，用下划线代替,只能放到最后
 *
 * 3. 异常处理
 *
 */
class Person
case class Teacher(var name:String,var age:Int) extends Person
case class Student(var name:String,var age:Int) extends Person


object MatchClass {

  def main(args: Array[String]) {
    //匹配值
    val name = "SKT.s9"
    name match{
      case e : String if e.equals("SKT.s9") => println(e+" failed")
      case e : String if e.equals("SKT.ees7") => println(e+" scuccess")
      case _ => println("u will are success"+name)
    }
    //匹配字符长度
    name match{
      case e : String if e.length == 4 => println(name+" failed")
      case e : String if e.length < 3 => println(name+" scuccess")
      case _ => println("u will are success")
    }

    //匹配字符类型
    var age:Any = "test"
    age = 123
    age match{
      case e : String => println(e+" scuccess")
      case e : String => println(e+" failed")
      case _ :Int => println("the type is Int type")
      case _ => println("u will are success")
    }

    //匹配class 的类型
    val teacher = new Teacher("laoda",18)
    val student = new Student("laoer",17)
    ident(teacher)
    ident(student)
    ident(new Person)

    //tuple
    val tuple:(String,String) = ("key","value")
    val line = "hadoop hive hbase"
    val Array(name1,name2,name3) = line.split(" ")
    println("name1:"+name1)
  }
  def ident(person: Person): Unit ={
    person match{
      case Teacher(name,age) => print("teacher...........")
      case Student(name,age) => print("stduent...........")
      case _ => print("..........................")
    }

  }
}
