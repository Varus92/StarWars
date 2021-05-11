package com.example.starwars.util

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.model.StarWars
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Adapters (private val mContacts: List<StarWars>) : RecyclerView.Adapter<Adapters.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nomeTextView = itemView.findViewById<TextView>(R.id.textViewNome)
        val button = itemView.findViewById<Button>(R.id.PersonButton)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapters.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.layout_recycleview, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: Adapters.ViewHolder, position: Int) {
        // Get the data model based on position
        val contact: StarWars = mContacts.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nomeTextView
        textView.setText(contact.name)


        viewHolder.button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                Log.d("Person","la persona selezionata è ${contact.name}")

            }
        }


    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mContacts.size
    }
}
