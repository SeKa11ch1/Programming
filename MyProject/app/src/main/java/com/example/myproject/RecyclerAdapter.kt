package com.example.myproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val context: Context, private val animals: List<AnimalBase>) : RecyclerView.Adapter<RecyclerAdapter.AnimalRecyclerHolder>() {

    /*private val onVoice: (AnimalBase, (IHasHome) -> String) -> Unit = { animal, voice ->

        val builder = AlertDialog.Builder(context)

        with(builder) {

            setTitle("${animal.javaClass.simpleName} ${animal.name} says:")

            setMessage(voice(animal as IHasVoice))

            setPositiveButton("OK", null)

            show()

        }

    }*/

    private val onMove: (AnimalBase) -> Unit =
        {
                animal -> val intent = Intent(context,MessageActivity::class.java)
                intent.putExtra("Message",animal.move())
                context.startActivity(intent)
        }

    private val onFindHome: (IHasHome) -> Unit =
        {
                 animal -> val intent = Intent(context,MessageActivity::class.java)
                 intent.putExtra("Message",animal.findHome())
                 context.startActivity(intent)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalRecyclerHolder =
        AnimalRecyclerHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.animal_recycler_item, parent, false))

    override fun onBindViewHolder(holder: AnimalRecyclerHolder, position: Int) {

        val animal = animals[position];

        holder.animalTypeHabitat.text = "Habitat: " + animal.type.toString()
        holder.animalTypeSpecies.text = "Species: " + animal.javaClass.simpleName
        holder.animalSize.text =  "Size: " + animal.size.toString()

        holder.animalMove.setOnClickListener { onMove(animal) }
        if(animal is IHasHome) {


            holder.animalFindHome.setOnClickListener { onFindHome(animal) }

        } else {


            holder.animalFindHome.visibility = View.GONE

        }

    }

    override fun getItemCount(): Int = animals.size

    class AnimalRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val animalTypeHabitat: TextView = itemView.findViewById(R.id.animal_type_habitat)
        val animalTypeSpecies: TextView = itemView.findViewById(R.id.animal_type_species)
        val animalSize: TextView = itemView.findViewById(R.id.animal_size)


        val animalFindHome: Button = itemView.findViewById(R.id.animal_find_home)
        val animalMove: Button = itemView.findViewById(R.id.animal_move)

    }

}