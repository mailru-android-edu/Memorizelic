package com.mailprojectteam.memorizelic.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.mailprojectteam.memorizelic.CardPage
import com.mailprojectteam.memorizelic.CardsOptions
import com.mailprojectteam.memorizelic.R
import java.security.AccessController.getContext
import kotlin.coroutines.coroutineContext

class CardsAdapter(private val decks: List<Deck>) :
    RecyclerView.Adapter<CardsAdapter.DeckViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeckViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_recycle_item, parent, false)
        val param = view.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(30,50,30,30)
        view.layoutParams = param

        return DeckViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeckViewHolder, position: Int) {
        val deck = decks[position]
        holder.bind(deck)
    }

    override fun getItemCount(): Int {
        println("Decks size = ${decks.size}")
        return decks.size
    }

    class DeckViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName: TextView = itemView.findViewById(R.id.deck_item__tv_name)
        private val tvAmount: TextView = itemView.findViewById(R.id.deck_item__tv_description)


        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, CardsOptions::class.java)
                startActivity(itemView.context, intent, null)
            }
        }



        fun bind(deck: Deck) {
            tvName.text = deck.title
            tvAmount.text = "Number of cards: " + deck.amountOfCards.toString()
        }

    }


}
