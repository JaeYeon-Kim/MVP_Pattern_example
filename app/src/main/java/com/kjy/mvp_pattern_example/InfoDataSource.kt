package com.kjy.mvp_pattern_example

import org.json.JSONObject

// Model - 1
interface InfoDataSource {
    interface LoadInfoCallback {
        fun onInfoLoaded(info: JSONObject)
        fun onDataNotAvailable()
    }

    fun getInfo(callback: LoadInfoCallback)
    fun saveInfo(info: JSONObject)
}