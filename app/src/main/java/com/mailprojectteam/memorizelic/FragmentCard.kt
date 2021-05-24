package com.mailprojectteam.memorizelic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.mailprojectteam.memorizelic.ui.home.Deck
import com.mailprojectteam.memorizelic.ui.home.WordAndTranslate
import kotlin.collections.ArrayList

class FragmentCard : Fragment() {
    private var displayAmount: String = ""
    private var displayWords: String = ""
    private var numberInRow: Int? = 0
    private var word: String = ""
    private var translateWord: String = ""
    private var checkCorrect: Boolean = false
    private var checkConfirmed: Boolean = false
    private lateinit var comunicator: Comunicator
    private lateinit var comunicatorFinishTest: ComunicatorFinishTest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)
        val wordListInNumer: TextView = view.findViewById(R.id.word_in_list_number)
        val wordAmount: TextView = view.findViewById(R.id.all_amount)
        val wordToTranslate: TextView = view.findViewById(R.id.word_to_translate)
        val wordTranslated: TextView = view.findViewById(R.id.translate)
        val enteredWord: EditText = view.findViewById(R.id.enter_word_translate)
        val buttonConfirm: Button = view.findViewById(R.id.button_confirm)
        val buttonBack: Button = view.findViewById(R.id.button_back)
        val buttonNext: Button = view.findViewById(R.id.button_next)
        val viewCorrect: AppCompatImageView = view.findViewById(R.id.correct_or_not)

        val deck = arguments?.getSerializable("deck") as? Deck
        val langEnToRu: Boolean? = arguments?.getBoolean("langEnToRu")
        numberInRow = arguments?.getInt("numberInList")
        if (langEnToRu!!) {
            word = deck?.getCardsList()?.get(numberInRow!! - 1)?.getEn()!!
            translateWord = deck.getCardsList()?.get(numberInRow!! - 1)?.getRu()!!
        }
        else {
            word = deck?.getCardsList()?.get(numberInRow!! - 1)?.getRu()!!
            translateWord = deck.getCardsList()?.get(numberInRow!! - 1)?.getEn()!!
        }
        wordToTranslate.setText(word)
        val arrayList: ArrayList<String>? = arguments?.getStringArrayList("list")
        val arrayAnswers: BooleanArray? = arguments?.getBooleanArray("arrayBoolean")
        wordAmount.setText(deck.getamount().toString())
        wordListInNumer.setText(numberInRow.toString())
        if (arrayList != null) {
            try {
                if (arrayList.isNotEmpty() && (numberInRow!! - 1) < arrayList.size){
                    word = arrayList.get(numberInRow!! - 1)
                    wordTranslated.setText(translateWord)
                    enteredWord.setText(arrayList.get(numberInRow!! - 1))
                    checkConfirmed = true
                    if (arrayAnswers?.get(numberInRow!! - 1)!!)
                        viewCorrect.setImageResource(R.drawable.ic_check_black_36dp)
                    else
                        viewCorrect.setImageResource(R.drawable.ic_clear_black_36dp)
                }
            } catch (e:ArrayIndexOutOfBoundsException){
                Log.e("array out of bounds", e.toString())
            }
        }

        comunicator = activity as Comunicator

        buttonConfirm.setOnClickListener{
            if (!checkConfirmed && !enteredWord.text.toString().equals("")){
                if (translateWord.equals(enteredWord.text.toString())){
                    viewCorrect.setImageResource(R.drawable.ic_check_black_36dp)
                    arrayAnswers?.set(numberInRow!! - 1, true)
                }else{
                    viewCorrect.setImageResource(R.drawable.ic_clear_black_36dp)
                    arrayAnswers?.set(numberInRow!! - 1, false)
                }
                word = wordToTranslate.text.toString()
                arrayList?.add(enteredWord.text.toString())
                wordTranslated.setText(translateWord)
                checkConfirmed = true
            }
        }

        buttonBack.setOnClickListener{
            if (arrayList != null && numberInRow!! > 1 && arrayAnswers != null) {
                numberInRow = numberInRow?.minus(1)
                comunicator.passDataToNewFragment(deck, numberInRow!!, arrayList, langEnToRu, arrayAnswers)
            }
        }

        buttonNext.setOnClickListener{
            if (arrayList != null && checkConfirmed && arrayAnswers != null) {
                if (numberInRow!! < deck.getamount()){
                    numberInRow = numberInRow?.plus(1)
                    comunicator.passDataToNewFragment(deck, numberInRow!!, arrayList, langEnToRu, arrayAnswers)
                } else {
                    comunicatorFinishTest = activity as ComunicatorFinishTest
                    comunicatorFinishTest.sendDataToFinishTestFragment(deck, arrayAnswers)
                }

            }
        }

        return view
    }
}