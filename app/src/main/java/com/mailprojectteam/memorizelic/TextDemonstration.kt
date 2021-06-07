package com.mailprojectteam.memorizelic

import android.app.AlertDialog
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mailprojectteam.memorizelic.ui.dashboard.Text
import com.mailprojectteam.memorizelic.ui.home.Deck

class TextDemonstration: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.text_activity)

        val textTitleView: TextView = findViewById(R.id.textView2)
        val textInScrollView: TextView = findViewById(R.id.textView3)

        val textClass = intent.getSerializableExtra("text") as Text


        textTitleView.setText(textClass.getTitle())
        textInScrollView.setText(textClass.getText())

        textTitleView.setOnClickListener{ onClick(textClass, textInScrollView)}
    }
    private fun onClick(textClass: Text, tvText: TextView) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.rename_recycle_view, null)
        val nameEditText: EditText = mDialogView.findViewById(R.id.word_edittext)
        val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Add/Change text")
        mBuilder.setPositiveButton("Ok") { _, _ ->
            if(!nameEditText.text.equals("")){
                textClass.setText(nameEditText.text.toString())
                tvText.setText(nameEditText.text.toString())
            }
        }

        mBuilder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        val mAlertDialog = mBuilder.show()
    }
}