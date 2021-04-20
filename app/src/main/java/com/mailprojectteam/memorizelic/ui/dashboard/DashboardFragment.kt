package com.mailprojectteam.memorizelic.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mailprojectteam.memorizelic.R
import com.mailprojectteam.memorizelic.ui.home.HomeViewModel

class DashboardFragment : Fragment() {
        private val text = generateTextList().toMutableList()

        var adapter: TextAdapter? = null

        private lateinit var homeViewModel: HomeViewModel


override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
): View? {
    val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
    val rvDeckList: RecyclerView = root.findViewById(R.id.hello_activity__rv_deck_list)
    adapter = TextAdapter(text)
    rvDeckList.adapter = adapter
    rvDeckList.layoutManager = LinearLayoutManager(context)
    val button: FloatingActionButton = root.findViewById(R.id.hello_activity__fab_add_movie)
    button.setOnClickListener { onClick() }
    return root
}

    private fun onClick() {
        text.add(
                Text(
                        "My new text",
                        0
                )
        )
        adapter?.notifyDataSetChanged()
    }
}

    private fun generateTextList(): List<Text> {
        return listOf(
                Text(
                        "Побег из Шоушенка",
                        2434
                ), Text(
                "Матрица",
                24521
        ), Text(
                "Как приручить дракона",
                233
        ), Text(
                "12 стульев",
                765
        ), Text(
                "Зеленая книга",
                86669
        ), Text(
                "Пираты Карибского моря: Проклятие Черной жемчужины",
                465
        ), Text(
                "Гарри Поттер и философский камень",
                11288
        )
        )
}