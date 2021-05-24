package com.mailprojectteam.memorizelic

import com.mailprojectteam.memorizelic.ui.home.Deck
import com.mailprojectteam.memorizelic.ui.home.WordAndTranslate

interface Comunicator {
    fun passDataToNewFragment(deck: Deck, numberInList: Int, arrayList: ArrayList<String>, langEnToRu: Boolean, arrayAnswers: BooleanArray)
}