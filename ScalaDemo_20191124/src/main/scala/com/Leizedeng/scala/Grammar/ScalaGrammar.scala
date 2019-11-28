package com.Leizedeng.scala.Grammar

import java.util

import scala.collection.immutable.IndexedSeq
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks

/**
 * Created by Administrator on 2019/11/24.
 * 熟练操作 alt+1 or alt+4 or alt+7
 */

/*
  1.scala默认的修饰符为public
  2.修饰符为private和protected
  3.没有static关键字
  4.如果方法没有返回值，默认返回值是Unit=void
  5.scala没有分号表示结束，没有return
  6.返回值就是方法中最后一行的值
  7.scala必须在object里运行
  8.object == public static class
 */
object ScalaGrammar {

  /**
   *
   * @param args
   */
  def main(args: Array[String]) :Unit = {
    println("hello world!")

    val list1 = List(1, 2, 3)

    if (list1.length == 3) {
      println("length is :" + list1.length)
    } else if (list1.length == 6) {
      println(s"length is : ${list1.length}")
    }

    println(1 to (4))

    for (x <- 1.to(10) if (x % 2 == 0)) {
      println(x)
    }

    //yield关键字的使用
    val forValue: IndexedSeq[Int] = for (x <- 1.to(10) if (x % 2 == 0)) yield {
      x * 2
    }

    //循环跳出
    val loop = new Breaks()
    loop.breakable {
      for (i <- forValue) {
        println("yield value : " + i)
        if (i == 16) {
          loop.break()
        }
      }
    }

    for (x <- list1) {
      println("list " + x)
    }
    print("==============九九乘法表-1==================")
    for (x <- 1.to(9)) {
      for (y <- 1.to(x)) {
        print(y + " * " + x + " = " + (x * y) + "\t")
      }
    }
    print("==============九九乘法表-2==================")
    for (x <- 1 to 9; y <- 1.to(x)) {
      if (y == 1) println()
      print(y + " * " + x + " = " + (x * y) + "\t")
    }
    print("=============九九乘法表-3===================")
    for {x <- 1 to 9
         y <- 1.to(x)} {
      if (y == 1) println()
      print(y + " * " + x + " = " + (x * y) + "\t")
    }

    //===================================================定义函数==============================
    //函数定义的格式
    /*
    def fun_name(args:Type,args:Type):Return_Type = {

    }
    例如：
    def function1(args1: Array[String],args2: String): Unit ={
    }

     */

    //定义一个无参无返回值函数
    def function1(): Unit = {
      println("定义一个无参无返回值函数:: 样式一")
    }
    //调用（定义函数给了括号，则调用时可以加括号，也可以不加）
    function1()

    def function2 {
      println("定义一个无参无返回值函数:: 样式二")
    }
    //调用（定义函数没有给括号，则调用时不能加括号）
    function2

    //定义有参有返回值函数
    def max(a: Int, b: Int): Int = {
      if (a > b) {
        a
      } else {
        b
      }
    }
    //调用
    val num: Int = max(2, 3)
    /*
      1.当函数体中只有一行，省略大括号
      例如：def max(a:Int,b:Int):Int = if(a>b) a else b
      2.当函数的返回值类型可以被推断时，可以省略返回值
      例如：def max(a:Int,b:Int) = {if(a>b) a else b}
      3.当没有返回值或为Unit，可以省略返回值定义
      例如：def printH(name:String){println(name)}
      当满足条件1和2时，可以省略大括号和返回值
      例如：def max(a:Int,b:Int) = if(a>b) a else b
     */
    //scala中函数定义可以嵌套
    def fun1(a: Int) {
      def fun2(b: Int): Unit = {
        println(s"${a} + ${b} = ${a + b}")
      }
    }



    //值函数
    def sayHello(name: String): Unit = {
      println(name + "hello")
    }

    val name = sayHello _
    name("leizedeng")

    val name2: String => Unit = sayHello _
    name2("LEIZEDENG")
    println("111111111")
    /*
      1. 匿名参数函数，在函数调用时指定参数的名称（名称与函数定义时名称一致）
      例如：sayHello(name="Leizedeng")
      def sayhello2(name:String="Tom",age:Int){println()}
      2.嵌套函数nestedfunction
      3.变长参数函数，类似java中的可变参数
        变长的参数传递的是一个数组，Array[String],类型不是数组类型
        foreach:用于取集合内的每个元素
      例如：def courcePrint(course:String*){
      4.匿名函数会根据方法体的执行自动判断返回值类型
      例如：(args:Type) => {}
      5.高阶函数：接受其他函数作为参数的函数
        函数a的参数是一个函数b，则函数a就称为高阶函数
      例如：def map(f:(A) = > B ):Array[B]
      }
     */
    //匿名函数
    def min = (a: Int, b: Int) => {
      if (a < b) a else b
    }

    //    (x:Int) => x+1

    val aa = (x: Int) => x + 1
    aa(1)

    def func(x: Int): Unit = {
      println()
    }

    val aa2 = func(_)
    val num1: Int = 5
    aa2(num1)


    //在al 按alt+enter键 自动补齐类型
    val al: Array[Int] = Array(1, 2, 3, 4, 5, 6)
    al.foreach(x => println(x))

    def courcePrint(course: String*): Unit = {
      course.foreach(x => println(x))
    }
    val a2 = Array("hadoop", "java", "hive", "hbase")
    //    courcePrint(a2)  //不允许这样操作
    courcePrint(a2: _*)

    //高阶函数 def map(f:(A) = > B ):Array[B]
    val ab = Array("1", "2", "3", "4")
    ab.map((x: String) => x.toInt)

    println("简单案列")
    (1 to 9).map("*" * _).foreach(println _)

    println("集合过滤filter")
    (1 to 9).filter(_ % 2 == 0).foreach(x => println(x.toString))

    println("reduceLeft实例")
    (1 to 3).reduceLeft((a, b) => a + b)

    (1 to 3).reduceLeft((a, b) => {
      println("a = " + a + "\t" + "b = " + b)
      a + b
    })

    //===================================================定义数组==============================

    //1. 不可变数组

    val array1 = Array(1, 2, 3, 4)
    array1(0)
    array1(1)
    array1.foreach(x => println(x))
    for (x <- 1 to array1.length - 1) println(x)

    val array2 = new Array[Int](5)
    //元组，存储不同类型
    val tuple = ("keep", 1, 2, 3)
    println(tuple._1)

    //2. 可变数组
    println("2. 可变数组")
    val imArray = scala.collection.mutable.ArrayBuffer[Int]()
    //添加元素
    imArray += 1
    imArray +=(2, 3, 4)
    imArray ++= Array(5, 6) //++= 可添加数组
    imArray.foreach(x => print(x + "\t"))
    println("\n")
    imArray.insert(1, 9, 9, 9) //第一个参数表示起始插入下标 ，输出：1	9	9	9	2	3	4	5	6
    imArray.foreach(x => print(x + "\t"))
    //移除元素
    println("\n移除元素 ")
    imArray.remove(1) //参数为下标
    imArray.foreach(x => print(x + "\t"))
    println("\nfor循环输出")
    for (i <- (imArray.length - 1).to(0, -1)) {
      print(imArray(i) + "\t")
    }
    println("\nuntil循环正常输出")
    for (i <- 0.until(imArray.length)) {
      print(imArray(i) + "\t")
    }
    println("\nuntil循环倒序输出")
    for (i <- 0.until(imArray.length).reverse) {
      print(imArray(i) + "\t")
    }

    //将数组所以元素转换为一个字符串
    println("\n将数组所以元素转换为一个字符串")
    println("\n 只打印输出")
    print(imArray.mkString + "\t") //输出一个字符串：19923456
    println("\n 以逗号分隔打印")
    print(imArray.mkString(",")) //输出一个字符串：1,9,9,2,3,4,5,6
    println("\n")
    print(imArray.mkString("<", ",", ">")) //输出一个字符串：<1,9,9,2,3,4,5,6>

    println("\n排序:sorted 默认升序")
    println(imArray.sorted)

    //    util.Sorting.quickSort(imArray.toArray)//用于对原集合进行排序操作
    //创建二维数组
    val secondArray = new Array[Array[Int]](5)

    //===================================================定义List集合==============================
    val list = ListBuffer[Int]()

    //添加元素
    list += 9
    list +=(123, 456)
    list -= 9
    list ++= List(1, 2, 7)
    list(1) = 10

//    var tlist = 8::list

    //将可变 转换为 不可变
    list.toList
    list.toArray

    //集合中常用方法
    //filter p:A => Boolean true:保留该值 false：过滤该值
    list.filter(x => x % 2 == 0)
    //对集合去重
    list.distinct

    //对于数据的处理：map
    val list2 = list.map(x => {
      if(x % 2 == 0 )
        x * 2
      else
        x * 3
    })
    val list3 = list.map(x => x.toString.split(" "))

    val list4 = List("hadoop spar hadoop","hadoop spar hadoop")
    //map用于对数据 一对一的处理，输出的是一个集合
    list4.map(x => x.split(" ")).foreach(print)//输出：[Ljava.lang.String;@457e2f02	[Ljava.lang.String;@5c7fa833
    println()
    //flatmap 扁平化处理，降维，输出的是给定集合中每一个元素
    list4.flatMap(x => x.split(" ")).foreach(x => print(x.toString+"\t"))//输出：hadoop	spar	hadoop	hadoop	spar	hadoop

    //排序
    val list5 = List(1,5,9,3,6)
    list5.sorted //升序
    list5.sortBy(x => x) //升序
    list5.sortBy(x => -x) //降序
    list5.sortWith((a,b) => a > b) //降序
    list5.sortWith((a,b) => a < b) //升序

    val list6 = List(List(0,0,0),List(1,2),List(6,5,9,8))
    list6.sortWith((a,b) => a.size > b.size)

    //分组
    list5.grouped(3) //按照个数对元素进行分组，每3个元素一组
    list5.groupBy( x => x%2 ) //

    //wordcount
    println("\n实现wordcount:")
    val list7 = List("hadoop spar hadoop","hadoop spar hadoop")
    list7.flatMap(x => x.split(" ")).groupBy(x => x).map(tuple => {
      val key   = tuple._1
      val value = tuple._2.size
      (key,value)
    }).foreach(println)

    //集合=头+尾
    list5.head  //集合的第一个元素
    list5.tail  //集合第一个以外的所有元素
    //反转元素
    list5.reverse
    val str = "23"
    println(str.reverse)
    //转换为string，添加分隔符
    list5.mkString("<",",",">")
    list5.max
    list5.min
    //fold方法，对于数值的处理，与reduce类型类似
    println(list.fold(1)((a,b) => a+b))
    println(list.foldLeft(1)((a,b) => a+b))
    list.foldLeft(scala.collection.mutable.ArrayBuffer[Int]())((a,b) => {
      println(a+"\t"+b)
      a += b
    })
    list.foldRight(1)((a,b) => a+b)

    //拉链操作
      //将List集合中每个元素添加下标
    val list8 = List(1,2,3,4,5,6)
    list8.zipWithIndex.foreach(println) //返回新集合，类型为二元组，key 为源集合的值，value是该值对应的下标
    val list9 = List("a","b","c")
    list8.zip(list9).foreach(println) //将2个集合组合成一个二元组

    //===================================================定义Set集合==============================
    /*
      1. Set集合内无重复，值唯一
     */

    //Set集合-不可变
    var set = Set(1,2,3,4,5,6)
    //添加元素
    set += 10
    set += 10
    set += 8

    //Set集合-可变
    import scala.collection.mutable

    var set1 = mutable.Set[Int]()
    set1 += 1
    set1 ++= List(1,2,3,4)
    set1 ++=Array(5,6)

    //取值
    for(x <- set1) print(x+"\t")

    //===================================================定义元组==============================
    /*
      1.下标从1开始
      2.与数组类似 ，存储任何类型
      3.元祖只能用下标取数
      4.最多支持22个元素
      5.元祖必需用圆括号表示
     */
    //二元组:括号中值的个数为2
    val hostname = ("hostname",3306)
    println(hostname._1)
    val hostname2 = "hostname" -> 8088
    println(hostname2._1)
    //swap :仅适用二元组，将key和value进行交换
    hostname2.swap  //输出：8088 -> "hostname"

    //元祖嵌套
    val tuple2 = List(("name",("age","sex")))
    tuple2.foreach(
      x => println(x._1+"\t"+x._2._1+"\t"+x._2._2)
    )
    //模式匹配输出
    tuple2.foreach {
      case (k1, (k2, k3)) => println(k1 + "\t" + k2 + "\t" + k3)
    }

    //===================================================定义Map==========================

    //不可变
    val map1 =Map(("key1","value1"),("key2","value2"))
    val map2 = Map("key1"->"v1","k2"->"v2")
    //取值方式
    map2.get("key1").get
    map2("key1") //当map2中不存在"key1",则会报错中止程序
    map2.getOrElse("key1",0) //当map2中不存在"key1",则赋默认值
    for(x <- map1 )println(x._1)
    for((key,value) <- map1 )println(key)

    map1.map(x => x._1+x._2 )

    //可变
    import scala.collection.mutable
    val imMap = mutable.Map[String,String]()

    //java集合与scala集合的互转
    import scala.collection.JavaConverters._
    val listJava: util.List[Int] = list5.asJava
    val listScala: mutable.Buffer[Int] = listJava.asScala

    val listWc = List("hadoop,spar, ,hadoop","hadoop,spar,hadoop")
    listWc.flatMap(x => x.trim().split(","))
          .map(x => x.trim)
          .filterNot(x => x.isEmpty)
          .map(x => (x,1))
          .groupBy(x => x._1)
          .map(tuple =>{
            val key =tuple._1
            val value = tuple._2.map(x =>x._2).sum
          (key,value)
          }).foreach(println)

  }
}
