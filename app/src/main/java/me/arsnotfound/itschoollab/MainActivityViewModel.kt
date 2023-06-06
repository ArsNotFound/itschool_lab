package me.arsnotfound.itschoollab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private val _textValue = MutableLiveData("")
    val textValue: LiveData<String> = _textValue

    private val _clickedValue = MutableLiveData(0)
    val clickedValue: LiveData<Int> = _clickedValue

    fun changeText(text: String) {
        _textValue.value = text
    }

    fun updateClicked() {
        _clickedValue.value = _clickedValue.value!! + 1
    }

}