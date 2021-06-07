package com.mailprojectteam.memorizelic.ui.dashboard

import android.app.AlertDialog
import android.content.Intent
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.mailprojectteam.memorizelic.CardsOptions
import com.mailprojectteam.memorizelic.R
import com.mailprojectteam.memorizelic.TextDemonstration
import com.mailprojectteam.memorizelic.ui.home.Deck

class TextAdapter(private val texts: List<Text>) :
    RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_recycle_item, parent, false)
        val param = view.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(30,50,30,30)

        view.layoutParams = param
        return TextViewHolder(view, texts)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val text = texts[position]
        holder.bind(text)
    }

    override fun getItemCount(): Int {
//        println("Texts amount = ${texts.size}")
        return texts.size
    }

    class TextViewHolder(itemView: View,  texts: List<Text>) : RecyclerView.ViewHolder(itemView) {

        private val tvName: TextView = itemView.findViewById(R.id.deck_item__tv_name)
        private val tvAmount: TextView = itemView.findViewById(R.id.deck_item__tv_description)


        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, TextDemonstration::class.java)
                intent.putExtra("text", texts.get(adapterPosition))
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
                        texts[adapterPosition].setTitle(nameEditText.text.toString())
                    }
                }

                mBuilder.setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                val mAlertDialog = mBuilder.show()
                return@setOnLongClickListener true
            }

        }

        fun bind(text: Text) {
            tvName.text = text.title
            tvAmount.text =  itemView.context.getString(R.string.words_amount) + text.getWordsAmount().toString()
        }

    }
}