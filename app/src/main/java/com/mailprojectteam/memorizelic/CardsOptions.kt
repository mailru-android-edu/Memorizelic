package com.mailprojectteam.memorizelic

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext

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
        /*spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                textForSpinner.text = "Spinner selected : ${parent.getItemAtPosition(position).toString()}"
            }*/
    }
}