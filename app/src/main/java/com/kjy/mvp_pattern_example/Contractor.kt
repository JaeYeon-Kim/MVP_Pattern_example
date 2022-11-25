package com.kjy.mvp_pattern_example

import org.json.JSONObject

// View와 Presenter의 Interface 정의
interface Contract {
    // 데이터를 입력받아서 이를 Activity에 출력
    interface View {
        fun showInfo(info: JSONObject)
    }

    interface Presenter {
        fun initInfo()      // Application이 시작될 때, 만약 저장된 데이터가 있다면 가져옴.
        fun setInfo(info: JSONObject)   // 데이터를 tv에 출력할 수 있도록 View에게 데이터 출력을 요청.
        fun saveInfo(info: JSONObject)  // View의 EditText로부터 가져온 데이터를 Model에게 저장시킨다.
    }
}