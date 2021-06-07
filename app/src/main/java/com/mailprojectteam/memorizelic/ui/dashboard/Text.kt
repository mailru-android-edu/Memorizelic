package com.mailprojectteam.memorizelic.ui.dashboard

import java.io.Serializable

data class Text(var title: String, var text: String): Serializable{


    @JvmName("getTitle1")
    fun getTitle(): String {
        return title
    }

    @JvmName("setTitle1")
    fun setTitle(title: String){
        this.title = title
    }

    @JvmName("setText1")
    fun setText(text: String){
        this.text = text
    }

    fun getWordsAmount():Int{
        val words = text.trim()
        val numberOfWords = words.split("\\s+".toRegex()).size
        return numberOfWords
    }

    @JvmName("getText1")
    fun getText(): String {
        return text
    }
}