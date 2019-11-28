package com.Leizedeng.scala.Grammar

/**
 * Created by Administrator on 2019/11/27.
 * 1. 主构造函数：在类名的后面
 *    所有的成员变量必须使用var或者val进行修饰
 * 2. 辅助构造函数：与java中的构造函数类似，在类中有对应的方法：this
 *    函数名：this
 *    辅助构造函数，必须调用主构造函数或者已存在的辅助构造函数
 *    第一行必须调用主构造函数
 */

class Person4(var name:String,val age:Int) {
    var school:String = "university"
    var sex:String = _

    //辅助构造函数this
    def this(name:String,age:Int,sex:String){
      this(name,age) //调用主构造函数
      this.sex = sex
    }
}

object Person4{
  def apply(name:String,age:Int,sex:String) : Person4 = {
    val p4 = new Person4(name,age,sex)
//    p4.sex = sex
    p4
  }
}