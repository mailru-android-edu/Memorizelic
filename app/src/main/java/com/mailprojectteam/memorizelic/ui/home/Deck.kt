package com.mailprojectteam.memorizelic.ui.home

import java.io.Serializable

data class Deck (var title: String, val list: ArrayList<WordAndTranslate>?) : Serializable{

    fun add(element: WordAndTranslate) {
        list!!.add(element)
    }

    fun getamount(): Int {
        return list!!.size
    }

    /*fun getamid(): Int {
        return id
    }*/

    @JvmName("setTitle1")
    fun setTitle(title: String){
        this.title = title
    }

    /*@JvmName("setId1")
    fun setId(id: Int){
        this.id = id
    }*/

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