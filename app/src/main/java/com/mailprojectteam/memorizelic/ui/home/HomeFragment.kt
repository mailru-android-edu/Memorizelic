package com.mailprojectteam.memorizelic.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mailprojectteam.memorizelic.R

class HomeFragment : Fragment() {

    private val decks = generateDecksList().toMutableList()

    var adapter: CardsAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val rvDeckList: RecyclerView = root.findViewById(R.id.hello_activity__rv_deck_list)
        adapter = CardsAdapter(decks)
        rvDeckList.adapter = adapter
        rvDeckList.layoutManager = LinearLayoutManager(context)
        val button: FloatingActionButton = root.findViewById(R.id.hello_activity__fab_add_movie)
        button.setOnClickListener { onClick() }
        return root
    }

    private fun onClick() {
        decks.add(
            Deck(
               requireActivity().getString(R.string.new_deck) ,
                    ArrayList()
            )
        )
        adapter?.notifyDataSetChanged()
    }
}

private fun generateDecksList(): List<Deck> {
    return listOf(
        Deck(
            "Сhristmas",
                arrayListOf(WordAndTranslate("elf", "эльф"))
        ), Deck(
//            2,
            "Weather",
            arrayListOf(WordAndTranslate("rainy", "дождливо"),
                    WordAndTranslate("sunny", "солнечно"))
    ), Deck(
//            3,
            "Food",
            arrayListOf(WordAndTranslate("egg", "яйцо"),
                    WordAndTranslate("apple", "яблоко"),
                    WordAndTranslate("milk", "молоко"),
                    WordAndTranslate("bread", "хлеб"),
                    WordAndTranslate("rice", "рис"),
                    WordAndTranslate("fish", "рыба"))
    ), Deck(
//            4,
            "Clothes",
            arrayListOf(WordAndTranslate("hat", "шляпа"),
                    WordAndTranslate("shoes", "обувь"),
                    WordAndTranslate("dress", "платье"),
                    WordAndTranslate("socks", "носки"))
        ), Deck(
//            5,
            "Parts of the body",
            arrayListOf(WordAndTranslate("shoulder", "плечо"))
        ), Deck(
//            6,
            "Animals",
            arrayListOf(WordAndTranslate("cat", "кошка"),
                    WordAndTranslate("elephant", "слон"),
                    WordAndTranslate("camel", "верблюд"))
        ), Deck(
//            7,
            "Family",
            arrayListOf(WordAndTranslate("sister", "сестра"),
                    WordAndTranslate("brother", "брат"))
        )
    )
}