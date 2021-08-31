package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(SetData.name)
        val score = intent.getStringExtra(SetData.score)
        val totalQues = intent.getStringExtra("total size")

        tv_congo_name.text = "Congratulations ${userName}!!"
        tv_score.text = "${score}/${totalQues}"

        finish_button.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }

}