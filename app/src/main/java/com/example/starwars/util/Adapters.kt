package com.example.starwars.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.example.starwars.model.StarWars
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class Adapters (private val listperson: List<StarWars>) : RecyclerView.Adapter<Adapters.ViewHolder>() {

    public var personListener: OnClickPersonListener? = null

    // dichiarazione del Publish( che invia un oggetto StarWars da inviare al fragment -> NextFragment   e dell'Observable
   // private val clickSubject = PublishSubject.create<StarWars>()
   // val clickEvent: Observable<StarWars> = clickSubject

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nomeTextView = itemView.findViewById<TextView>(R.id.textViewNome)
        val button = itemView.findViewById<ImageView>(R.id.Freccia)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapters.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_recycleview, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: Adapters.ViewHolder, position: Int) {

        // Get the data model based on position
        val contact: StarWars = listperson.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nomeTextView
        textView.setText(contact.name)

        //vado a salvare nel tag
        viewHolder.button.tag = position





        viewHolder.button.setOnClickListener {
                val setContent = listperson.get(it.tag as Int) //faccio un cast
            //passo all interface nella funzione onClickPerson il personaggio che abbiamo selezionato
            personListener?.onClickPerson(setContent)


            //RX nel momento in cui andiamo a cliccare nel button verra creato un Publisher che tramite la funzione onNext
            //che (Provides the Observer with a new item to observe) che inviera l'oggetto che abbiamo selezionato
            //clickSubject.onNext(setContent)

        }


    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return listperson.size
    }


    //mi creo un interface per poter salvare i dati della recycleView e poter richiamare il bottone non dentro l Adapter ma dentro il fragment e poter
    //inserire i dati per poterli passare tramite la Safe Args
    interface OnClickPersonListener{
        //inizializzo la funzione
        fun onClickPerson(personStarWars: StarWars)

    }
}
