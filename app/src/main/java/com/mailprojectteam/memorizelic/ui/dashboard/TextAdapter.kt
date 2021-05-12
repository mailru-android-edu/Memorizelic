package com.mailprojectteam.memorizelic.ui.dashboard

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mailprojectteam.memorizelic.R

class TextAdapter(private val texts: List<Text>) :
    RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_recycle_item, parent, false)
        val param = view.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(30,50,30,30)
        view.layoutParams = param
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val text = texts[position]
        holder.bind(text)
    }

    override fun getItemCount(): Int {
        println("Texts amount = ${texts.size}")
        return texts.size
    }

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName: TextView = itemView.findViewById(R.id.deck_item__tv_name)
        private val tvAmount: TextView = itemView.findViewById(R.id.deck_item__tv_description)

/*        init {
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    tvName.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }*/

        fun bind(text: Text) {
            tvName.text = text.title
            tvAmount.text =  itemView.context.getString(R.string.words_amount) + text.wordsAmount.toString()
        }

    }


}