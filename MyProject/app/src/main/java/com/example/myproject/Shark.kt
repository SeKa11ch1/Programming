package com.example.myproject

class Shark(size:Int):AnimalBase(Type.water, size )
    {
    override fun move():String {
       return "пливу"
    }
    var bloodDetectionRange:Int = 400
}