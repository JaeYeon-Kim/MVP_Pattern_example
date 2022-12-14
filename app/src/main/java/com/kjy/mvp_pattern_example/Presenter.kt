package com.kjy.mvp_pattern_example

import android.util.Log
import org.json.JSONObject


class Presenter(val view: Contract.View, val repository: InfoRepository): Contract.Presenter {
    override fun initInfo() {
        repository.getInfo(object: InfoDataSource.LoadInfoCallback{
            override fun onInfoLoaded(info: JSONObject) {
                view.showInfo(info)
            }

            override fun onDataNotAvailable() {
                // Nothing
            }
        })
    }

    override fun setInfo(info: JSONObject) {
        view.showInfo(info)
        Log.d("KBW", info.toString())
    }

    override fun saveInfo(info: JSONObject) {
        repository.saveInfo(info)
    }

}