package com.example.myproject

class Eagle(size:Int):AnimalBase(Type.air, size ), IHasHome
    {
    override fun move():String {
        return "лечу на висоті $flyAltitude м"
    }
    var flyAltitude:Int = 7000
    override fun findHome():String {
        return "створюю гніздо"
    }

}