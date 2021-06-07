package com.mailprojectteam.memorizelic

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mailprojectteam.memorizelic.ui.home.Deck

const val BASE_URL =  "https://google-translate1.p.rapidapi.com/"

class CardsOptions : AppCompatActivity(), Comunicator, ComunicatorFinishTest, ComunicatorReturnToDeck{

    var jsonResults: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.cards_options)
        val deck = intent.getSerializableExtra("deck") as Deck
//        val decks = intent.getSerializableExtra("decks") as Decks
//        val chosed = intent.getIntExtra("chose", 1)
        val fragmentDeck = FragmentDeck()
        val bundle = Bundle()
        bundle.putSerializable("deck", deck)
        fragmentDeck.arguments = bundle

        val trasactionDeck = supportFragmentManager
                .beginTransaction().replace(R.id.fragment_container, fragmentDeck)
                .commit()
    }




    override fun passDataToNewFragment(deck: Deck, numberInList: Int, arrayList: ArrayList<String>, langEnToRu: Boolean, arrayAnswers: BooleanArray) {
        val bundle = Bundle()
        bundle.putSerializable("deck", deck)
        bundle.putInt("numberInList", numberInList)
        bundle.putStringArrayList("list", arrayList)
        bundle.putBoolean("langEnToRu", langEnToRu)
        bundle.putBooleanArray("arrayBoolean", arrayAnswers)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentCard = FragmentCard()
        fragmentCard.arguments = bundle

        transaction.replace(R.id.fragment_container, fragmentCard).commit()
    }

    override fun sendDataToFinishTestFragment(deck: Deck, listOfAnswers: BooleanArray) {
        val bundle = Bundle()
        bundle.putSerializable("deck", deck)
        bundle.putBooleanArray("arrayBoolean", listOfAnswers)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentFinishTest = FragmentFinishTest()
        fragmentFinishTest.arguments = bundle

        transaction.replace(R.id.fragment_container, fragmentFinishTest).commit()
    }

    override fun sendDataToDeckFragment(deck: Deck) {
        val fragmentDeck = FragmentDeck()
        val bundle = Bundle()
        bundle.putSerializable("deck", deck)
        fragmentDeck.arguments = bundle

        val trasactionDeck = supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragmentDeck)
                .commit()
    }
}

