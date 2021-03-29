package com.mailprojectteam.memorizelic.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "You can configure the mode for memorizing words. You will have to write a translation of the words appearing in front of you"
    }
    val text: LiveData<String> = _text
}