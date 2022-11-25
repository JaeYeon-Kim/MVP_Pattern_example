package com.kjy.mvp_pattern_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kjy.mvp_pattern_example.databinding.ActivityMainBinding
import org.json.JSONObject

// 뷰 작성하기
class MainActivity : AppCompatActivity(), Contract.View {

    // Presenter와 Model 변수 선언
    private lateinit var presenter: Presenter

    private lateinit var repository: InfoRepository

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        repository = InfoRepository(this)
        presenter = Presenter(this@MainActivity, repository)

        presenter.initInfo()
        initButtonListener()
    }


    // 텍스트 변경
    override fun showInfo(info: JSONObject) {
        binding.outputName.text = info.getString("name")
        binding.outputEmail.text = info.getString("email")

        Log.d("KBW", info.getString("name"))
        Log.d("KBW", info.getString("email"))
    }

    // 버튼에 대한 이벤트 처리 함수
    fun initButtonListener() {
        binding.btnSave.setOnClickListener {
            Log.d("KBW", "hi")
            var info = JSONObject()
            info.put("name", binding.etName.text.toString())
            info.put("email", binding.etEmail.text.toString())

            binding.etName.text.clear()
            binding.etEmail.text.clear()

            presenter.setInfo(info)
            presenter.saveInfo(info)
        }
    }
}