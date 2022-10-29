package com.example.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val animals: MutableList<AnimalBase> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animalRecycler: RecyclerView = findViewById(R.id.animal_recycler)

        animalRecycler.layoutManager = LinearLayoutManager(this)
        animalRecycler.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        for (i in 0..20) {

            when(Random.nextInt(0, 3)) {

                0 -> animals.add(Bear(Random.nextInt(70, 150)))
                1 -> animals.add(Eagle(Random.nextInt(75, 88)))
                2 -> animals.add(Shark(Random.nextInt(400, 490)))

            }

        }

        animalRecycler.adapter = RecyclerAdapter(this, animals)
    }
}