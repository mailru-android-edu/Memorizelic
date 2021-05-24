package com.mailprojectteam.memorizelic.ui.home

import java.io.Serializable

class WordAndTranslate : Serializable {

    private var enWord: String
    private var ruWord: String

    constructor(enWord: String, ruWord: String){
        this.enWord = enWord
        this.ruWord = ruWord
    }

    fun setRu(newWord: String){
        ruWord = newWord
    }

    fun setEn(newWord: String){
        enWord = newWord
    }

    fun getRu(): String {
        return ruWord
    }

    fun getEn(): String {
        return enWord
    }

    override fun toString(): String {
        return "$enWord' '$ruWord"
    }
}
