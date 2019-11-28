package com.Leizedeng.scala.Grammar

/**
 * Created by Administrator on 2019/11/27.
 */

object TestApply {

  def main(args: Array[String]) {
    val p3 =  ScalaPersonMain()
    p3.func1()
    p3.name
    val pp3 = ScalaPersonMain("frank")
    pp3.func1()
    pp3.name

    val person04 = new Person4("leizedeng",17)
    val person0401 = new Person4("Leizedneg",18,"male")
    val person0402 = Person4("Leizedneg",19,"male")
  }
}
