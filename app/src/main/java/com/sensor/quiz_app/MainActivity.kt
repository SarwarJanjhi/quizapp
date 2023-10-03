package com.sensor.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



   btn_start.setOnClickListener {
       if (et_N.text.toString().isEmpty()){
           Toast.makeText(this, "please eneter the name", Toast.LENGTH_SHORT).show()
       }
       else{
           val intent = Intent(this,QuizQuestionWork::class.java)
           intent.putExtra(Constants.User_name,et_N.text.toString())
           startActivity(intent)
           finish()
       }
   }


    }

}