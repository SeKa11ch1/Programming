package com.example.myproject

abstract class AnimalBase (val type:Type, val size:Int){
    abstract fun move():String;
    enum class Type { land, water, air, }

}