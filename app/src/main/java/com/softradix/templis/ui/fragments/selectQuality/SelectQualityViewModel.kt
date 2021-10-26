package com.softradix.templis.ui.fragments.selectQuality

import  androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectQualityViewModel @Inject constructor() : ViewModel() {

    var totalMutableLiveData = MutableLiveData("$0")


    fun totalPriceData(video: Int, audio: Int, ticket: Int) {
        totalMutableLiveData.value = "$${video + audio + ticket}"
    }


}