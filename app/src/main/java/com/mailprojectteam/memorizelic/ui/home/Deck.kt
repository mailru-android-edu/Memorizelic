package com.mailprojectteam.memorizelic.ui.home

import android.os.Parcelable
import java.io.Serializable

data class Deck(val title: String, val list: ArrayList<WordAndTranslate>?) : Serializable{

    private fun add(element: WordAndTranslate) {
        list!!.add(element)
    }

    fun getamount(): Int {
        return list!!.size
    }

    fun gettitle(): String {
        return title
    }

    fun getCardsList(): ArrayList<WordAndTranslate>? {
        return list
    }

    fun toArrayListString(): ArrayList<String>? {
        val arrayList: ArrayList<String>? = null
        list!!.forEach {
            arrayList?.add(it.toString())
        }

        return arrayList
    }
}