package com.mailprojectteam.memorizelic

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.common.model.RemoteModelManager
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.TranslateRemoteModel
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import com.mailprojectteam.memorizelic.ui.home.Deck
import com.mailprojectteam.memorizelic.ui.home.WordAndTranslate
import java.lang.Exception


class FragmentDeck() : Fragment() {

    private var word: String = ""
    private lateinit var comunicator: Comunicator
    private var checkLang: Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_deck, container, false)

        comunicator = activity as Comunicator

        var deck = arguments?.getSerializable("deck") as? Deck

        val swipeButton: ImageView = view.findViewById(R.id.swipe_but)
        val leftText: TextView = view.findViewById(R.id.text_left)
        val rightText: TextView = view.findViewById(R.id.text_right)
        val wordsAmo: TextView = view.findViewById(R.id.text_statistic)
        val titleName: TextView = view.findViewById(R.id.title)

        if (deck != null) {
            wordsAmo.setText(deck.getamount().toString())
            titleName.setText(deck.gettitle())
        }else
            Toast.makeText(context, "deck is null", Toast.LENGTH_SHORT)
        swipeButton.setOnClickListener {
            if (checkLang) {
                rightText.setText(getString(R.string.language_En))
                leftText.setText(getString(R.string.language_Ru))
                checkLang = false
            } else {
                rightText.setText(getString(R.string.language_Ru))
                leftText.setText(getString(R.string.language_En))
                checkLang = true
            }
        }



val startDialog: AppCompatButton = view.findViewById(R.id.start_dialog)
startDialog.setOnClickListener {


    val mDialogView = LayoutInflater.from(context).inflate(R.layout.edit_text_layout, null)
    val swipeButtonDia: ImageView = mDialogView.findViewById(R.id.swipe_but)
    val leftTextDia: TextView = mDialogView.findViewById(R.id.text_left)
    val rightTextDia: TextView = mDialogView.findViewById(R.id.text_right)
    var checkDiaLanguage: Boolean = true

    swipeButtonDia.setOnClickListener {
        if (checkDiaLanguage) {
            rightTextDia.setText(getString(R.string.language_En))
            leftTextDia.setText(getString(R.string.language_Ru))
            checkDiaLanguage = false
        } else {
            rightTextDia.setText(getString(R.string.language_Ru))
            leftTextDia.setText(getString(R.string.language_En))
            checkDiaLanguage = true
        }
    }


    val mBuilder = AlertDialog.Builder(context)
        .setView(mDialogView)
        .setTitle("Add your word")
    mBuilder.setPositiveButton("Ok") { _, _ ->
        word = mDialogView.findViewById<EditText>(R.id.word_edittext).text.toString()

        val optionsBuilder = TranslatorOptions.Builder()
        if (checkDiaLanguage){
            optionsBuilder
                    .setSourceLanguage(TranslateLanguage.ENGLISH)
                    .setTargetLanguage(TranslateLanguage.RUSSIAN)
        } else{
            optionsBuilder
                    .setSourceLanguage(TranslateLanguage.RUSSIAN)
                    .setTargetLanguage(TranslateLanguage.ENGLISH)
        }
        val options = optionsBuilder.build()
        val englishToRussianTranslator = Translation.getClient(options)


        var conditions = DownloadConditions.Builder()
//                .requireWifi()
                .build()
        englishToRussianTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener {
                    Toast.makeText(view.context, "Wait file to download", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception: Exception ->
                    Toast.makeText(view.context, "Could not download", Toast.LENGTH_SHORT).show()
                }

        englishToRussianTranslator.translate(word)
                .addOnSuccessListener { translatedText ->
                    if (word.equals(translatedText)) {
                        Toast.makeText(view.context, "Not right language", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(view.context, translatedText, Toast.LENGTH_SHORT).show()
                        if (checkDiaLanguage)
                            deck?.add(WordAndTranslate(word, translatedText))
                        else
                            deck?.add(WordAndTranslate(translatedText, word))
                        wordsAmo.setText(deck?.getamount().toString())
                        Log.i("Translate", translatedText)
                    }
                }
                .addOnFailureListener { exception: Exception  ->
                    Log.e("Error", exception.toString())
                    Toast.makeText(view.context, "Some problem happened", Toast.LENGTH_SHORT).show()
                }
    }

    mBuilder.setNegativeButton("Cancel") { dialog, _ ->
        dialog.dismiss()
    }
    val mAlertDialog = mBuilder.show()
}

        view
                .findViewById<Button>(R.id.button_start_test)
                .setOnClickListener{
                    if (deck != null) {
                        if (deck.getamount() > 0){
                            comunicator.passDataToNewFragment(deck, 1,
                                    ArrayList<String>(deck.getamount()), checkLang,
                                    BooleanArray(deck.getamount())
                            )
                        }
                    }
                }
        return view
    }
}