package com.sensor.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.view.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.User_name)
        tv_Username.text = username
        val totalQuestions = intent.getIntExtra(Constants.Total_Questions, 0)
        val correctAnswers = intent.getIntExtra(Constants.Correct_Answers, 0)

        if (correctAnswers<3){
            Toast.makeText(this, "YOU CAN DO BETTER THAN THIS", Toast.LENGTH_SHORT).show()

            iv_trophy.setImageResource(R.drawable.thumb)
        }

        tv_score.text = " your score is $correctAnswers out of $totalQuestions"

        btn_finsih.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}