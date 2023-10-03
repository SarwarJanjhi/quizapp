package com.sensor.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question_work.*

class QuizQuestionWork : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUSerName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_work)

        mUSerName = intent.getStringExtra(Constants.User_name)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionView()
        if (mCurrentPosition == mQuestionList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }

        Progress_Bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition " + "/" + Progress_Bar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionone
        tv_option_two.text = question.optiontwo
        tv_option_three.text = question.optionthree
        tv_option_four.text = question.optionfour

    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.tv_default_options
            )

        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.tv_option_one -> {
                SelectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                SelectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                SelectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                SelectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.User_name,mUSerName)
                            intent.putExtra(Constants.Correct_Answers,mCorrectAnswers)
                            intent.putExtra(Constants.Total_Questions,mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.CorrectAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_answe_bcr)
                    } else {
                        mCorrectAnswers++

                    }
                    answerView(question.CorrectAnswer, R.drawable.correct_answer)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> tv_option_one.background = ContextCompat.getDrawable(
                this,
                drawableView
            )

            2 -> tv_option_two.background = ContextCompat.getDrawable(
                this,
                drawableView
            )
            3 -> tv_option_three.background = ContextCompat.getDrawable(
                this,
                drawableView
            )
            4 -> tv_option_four.background = ContextCompat.getDrawable(
                this,
                drawableView
            )

        }
    }

    private fun SelectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )
    }
}

