package com.example.myproject

class Bear(size:Int):AnimalBase(Type.land, size ), IHasHome
    {
    override fun move():String {
        return "біжу"
    }
    fun hibernation() {
        print("впадаю в сплячку")
    }

    override fun findHome():String {
      return "знахожу місце для сплячки"
    }

}