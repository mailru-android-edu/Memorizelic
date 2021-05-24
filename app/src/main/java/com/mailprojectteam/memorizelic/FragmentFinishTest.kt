package com.mailprojectteam.memorizelic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.mailprojectteam.memorizelic.ui.home.Deck

class FragmentFinishTest : Fragment() {
    private lateinit var comunicator: ComunicatorReturnToDeck


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_finish_test, container, false)
        comunicator = activity as ComunicatorReturnToDeck

        val button: AppCompatButton = view.findViewById(R.id.finish)
        val correctAnswers: TextView = view.findViewById(R.id.correct_answers)
        val incorrectAnswers: TextView = view.findViewById(R.id.incorrect_answers)

        val arrayAnswers: BooleanArray? = arguments?.getBooleanArray("arrayBoolean")
        val deck = arguments?.getSerializable("deck") as? Deck
        var amountCorrect: Int = 0
        var amountInCorrect: Int = 0

        arrayAnswers?.forEach {
            if (it)
                amountCorrect += 1
            else
                amountInCorrect += 1
        }

        correctAnswers.setText(amountCorrect.toString())
        incorrectAnswers.setText(amountInCorrect.toString())

        button.setOnClickListener {
            comunicator.sendDataToDeckFragment(deck!!)

        }


        return view
    }

}