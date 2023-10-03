package com.sensor.quiz_app

object Constants {
    const val User_name: String = "name"
    const val Total_Questions: String = "total questions"
    const val Correct_Answers: String = "correct answers"
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val ques1 = Question(
            1,
            "This flag belongs to which country",
            R.drawable.argentina,
            "China",
            "Argentina",
            "Brazil",
            "Turkey",
            2
        )
        questionList.add(ques1)


        //2
        val ques2 = Question(
            2,
            "This flag belongs to which country",
            R.drawable.russia,
            "China",
            "Argentina",
            "Russia",
            "Turkey",
            3
        )

        questionList.add(ques2)
        //3
        val ques3 = Question(
            3,
            "This flag belongs to which country",
            R.drawable.uzebikistan,
            "Uzebikistan",
            "Argentina",
            "Brazil",
            "Turkey",
            1
        )
        questionList.add(ques3)
        //4
        val ques4 = Question(
            4,
            "This flag belongs to which country",
            R.drawable.brazil,
            "China",
            "Argentina",
            "Brazil",
            "Turkey",
            3
        )
        questionList.add(ques4)
        //5
        val ques5 = Question(
            5,
            "This flag belongs to which country",
            R.drawable.china,
            "China",
            "Argentina",
            "Brazil",
            "Turkey",
            1
        )
        questionList.add(ques5)
        return questionList
    }
}