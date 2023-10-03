package com.sensor.quiz_app

data class Question (

    val id:Int,
    val question:String,
    val image:Int,
    val optionone:String,
    val optiontwo:String,
    val optionthree:String,
    val optionfour:String,
    val CorrectAnswer:Int
)
