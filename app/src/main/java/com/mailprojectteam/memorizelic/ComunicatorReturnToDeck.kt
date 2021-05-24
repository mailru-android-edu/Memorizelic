package com.mailprojectteam.memorizelic

import com.mailprojectteam.memorizelic.ui.home.Deck

interface ComunicatorReturnToDeck {
    fun sendDataToDeckFragment(deck: Deck)
}