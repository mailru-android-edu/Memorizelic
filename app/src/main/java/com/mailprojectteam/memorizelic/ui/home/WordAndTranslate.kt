package com.mailprojectteam.memorizelic.ui.home

class WordAndTranslate {

    private var enWord: String
    private var ruWord: String

    constructor(enWord: String, ruWord: String){
        this.enWord = enWord
        this.ruWord = ruWord
    }

    private fun setRu(newWord: String){
        ruWord = newWord
    }

    private fun setEn(newWord: String){
        enWord = newWord
    }

    private fun getRu(): String {
        return ruWord
    }

    private fun getEn(): String {
        return enWord
    }

    override fun toString(): String {
        return "$enWord' '$ruWord"
    }
}
