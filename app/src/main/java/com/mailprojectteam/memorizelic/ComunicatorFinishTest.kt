package com.mailprojectteam.memorizelic

import com.mailprojectteam.memorizelic.ui.home.Deck

interface ComunicatorFinishTest {
    fun sendDataToFinishTestFragment(deck: Deck, listOfAnswers: BooleanArray)
}