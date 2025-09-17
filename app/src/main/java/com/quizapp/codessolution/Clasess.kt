package com.quizapp.codessolution





fun main() {
//var ab = Cars()
//    println(ab.a)

//    var ev = Vehical("Honda","5666")
//    println(ev.name)
//    println(ev.model)


}

class Cars : Vehical("",""){
    val a = 25;
}

open class Vehical(var name: String, var model: String = "2008"){
}

class Circle (val radius : Double){
    constructor( Diameter : Int) : this(Diameter/2.0){
            println("Diameter is $Diameter")
    }
    constructor(name:String):this(2.0){}

    fun sum( x : Int,  y : Int) : Int{
            var c = 0

        return c
    }


}