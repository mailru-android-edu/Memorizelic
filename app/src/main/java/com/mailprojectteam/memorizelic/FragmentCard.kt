package com.mailprojectteam.memorizelic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.mailprojectteam.memorizelic.ui.home.Deck
import java.util.ArrayList

class FragmentCard : Fragment() {
    private var displayAmount: String = ""
    private var displayWords: String = ""
    private var numberInRow: Int? = 0
    private var word: String = ""
    private var checkCorrect: Boolean = false
    private var checkConfirmed: Boolean = false
    private lateinit var comunicator: Comunicator

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
        val buttonConfirm: Button = view.findViewById(R.id.button_confirm)
        val buttonBack: Button = view.findViewById(R.id.button_back)
        val buttonNext: Button = view.findViewById(R.id.button_next)
        val viewCorrect: AppCompatImageView = view.findViewById(R.id.correct_or_not)

        val deck = arguments?.getSerializable("deck") as? Deck
        numberInRow = arguments?.getInt("numberInList")
        val arrayList: ArrayList<String>? = arguments?.getStringArrayList("list")
        wordAmount.setText(deck?.getamount().toString())
        wordListInNumer.setText(numberInRow.toString())

        comunicator = activity as Comunicator

        buttonConfirm.setOnClickListener{
            viewCorrect.setImageResource(R.drawable.ic_check_black_36dp)
            word = wordToTranslate.text.toString()
            checkConfirmed = true
        }

        buttonBack.setOnClickListener{
            if (deck != null && arrayList != null && checkConfirmed) {
                numberInRow = numberInRow?.minus(1)
                comunicator.passDataToNewFragment(deck, numberInRow!!, arrayList)
            }
        }

        buttonNext.setOnClickListener{
            if (deck != null && arrayList != null && checkConfirmed) {
                numberInRow = numberInRow?.plus(1)
                comunicator.passDataToNewFragment(deck, numberInRow!!, arrayList)
            }
        }

        return view
    }
}