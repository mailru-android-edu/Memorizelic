package com.mailprojectteam.memorizelic.ui.home

import android.app.AlertDialog
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import com.mailprojectteam.memorizelic.CardsOptions
import com.mailprojectteam.memorizelic.R
import java.io.Serializable
import java.lang.Exception

class CardsAdapter(private val decks: List<Deck>) :
    RecyclerView.Adapter<CardsAdapter.DeckViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeckViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_recycle_item, parent, false)
        val param = view.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(30,50,30,30)
        view.layoutParams = param
        return DeckViewHolder(view, decks)
    }

    override fun onBindViewHolder(holder: DeckViewHolder, position: Int) {
        val deck = decks[position]
        holder.bind(deck)
    }

    override fun getItemCount(): Int {
//        println("Decks size = ${decks.size}")
        return decks.size
    }

    class DeckViewHolder(itemView: View, decks: List<Deck>) : RecyclerView.ViewHolder(itemView) {

        private val tvName: TextView = itemView.findViewById(R.id.deck_item__tv_name)
        private val tvAmount: TextView = itemView.findViewById(R.id.deck_item__tv_description)


        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, CardsOptions::class.java)
//                intent.putExtra("decks", Decks(decks))
//                intent.putExtra("chose", adapterPosition)
                intent.putExtra("deck", decks[adapterPosition])
                startActivity(itemView.context, intent, null)
            }

            itemView.setOnLongClickListener{
                val mDialogView = LayoutInflater.from(itemView.context).inflate(R.layout.rename_recycle_view, null)
                val nameEditText: EditText = mDialogView.findViewById(R.id.word_edittext)
                val mBuilder = AlertDialog.Builder(itemView.context)
                        .setView(mDialogView)
                        .setTitle("Change name")
                mBuilder.setPositiveButton("Ok") { _, _ ->
                    if(!nameEditText.text.equals("")){
                        tvName.setText(nameEditText.text.toString())
                        decks[adapterPosition].setTitle(nameEditText.text.toString())
                    }
                }

                mBuilder.setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                val mAlertDialog = mBuilder.show()
                return@setOnLongClickListener true
            }
        }



        fun bind(deck: Deck) {
            tvName.text = deck.title
            tvAmount.text = itemView.context.getString(R.string.cards_amount) + deck.getamount().toString()
        }

    }


}
