package com.Leizedeng.scala.Grammar

/**
 * Created by Administrator on 2019/11/27.
 */
class Person01 {
    var name:String = "skt"
    var age:Int     = 19

    def eat(): Unit ={
      println(name+" eating......")
    }

    def watchTV(name:String): Unit ={
      println(name+" watching TV ......")
    }

    def sayHello(name:String):String={
      name+" Good morning!"
    }
}
