package com.kjy.mvp_pattern_example

import android.content.Context
import org.json.JSONObject


// model - 1 을 상속받아서 멤버 변수를 가져옴.
class InfoLocalDataSource(context: Context): InfoDataSource {

    // MODE_PRIVATE: 자기 앱 내에서 사용. 외부 앱에서 접근 불가
    // editor로 저장하고 데이터 불러오기
    private val sharedPreferences = context.getSharedPreferences("info", Context.MODE_PRIVATE)

    private val editor = sharedPreferences.edit()

    // 저장한 데이터를 불러오는 역할
    override fun getInfo(callback: InfoDataSource.LoadInfoCallback) {
        var info = sharedPreferences.getString("info", null)
        if(info != null) {
            callback.onInfoLoaded(JSONObject(info))
        } else {
            callback.onDataNotAvailable()
        }
    }

    override fun saveInfo(info: JSONObject) {
        // sharedPreferences로 데이터를 저장
        editor.putString("info", info.toString())
        editor.commit()         // 변경한 업데이트를 동기적으로 저장
    }
}