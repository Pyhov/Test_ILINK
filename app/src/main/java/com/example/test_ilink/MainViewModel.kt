package com.example.test_ilink

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import java.net.URL


class MainViewModel: ViewModel() {

    val urlPicture = MutableLiveData<String>()
    init {


    }

    override fun onCleared() {
        urlPicture.value=""
        super.onCleared()
    }
    fun duckLoad(){
        var url:String ="https://random-d.uk/api/v2/random"
        doAsync {
          val apiResponse = URL(url).readText()
          val urlImage = JSONObject(apiResponse).getString("url")
            urlPicture.postValue(urlImage)
        }
    }
    fun catLoad(){
        var url:String ="https://thatcopy.pw/catapi/rest"
        doAsync {
            val apiResponse = URL(url).readText()
            val urlImage = JSONObject(apiResponse).getString("url")
            urlPicture.postValue(urlImage)
        }
    }

}