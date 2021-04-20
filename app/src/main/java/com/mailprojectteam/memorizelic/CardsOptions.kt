package com.mailprojectteam.memorizelic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class CardsOptions : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cards_options)

        val languages = arrayOf("English","Russian")

        val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                languages
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        val spinner: Spinner = findViewById(R.id.spinner)

        spinner.adapter = adapter

        val startSettingsButton: Button = findViewById(R.id.button_start_test);

        startSettingsButton.setOnClickListener {
            val intent = Intent(this@CardsOptions, CardPage::class.java)
            startActivity(intent)
        }

        val startDialog: Button = findViewById(R.id.start_dialog)
        startDialog.setOnClickListener {
            MyCustomDialog().show(supportFragmentManager, "Write down your word")
        }

        /*spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                textForSpinner.text = "Spinner selected : ${parent.getItemAtPosition(position).toString()}"
            }*/
    }

}