package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var currPosition: Int = 1
    private var questionList: ArrayList<QuestionData> ?= null
    private var selectedOption: Int = 0

    private var name: String ?= null
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        name = intent.getStringExtra(SetData.name)

        questionList = SetData.getQuestion()

//        var que = questionList!![0]
//        tv_question.text = que.question
//        option1.text = que.option_one
//        option2.text = que.option_two
//        option3.text = que.option_three
//        option4.text = que.option_four
//
//        option1.setOnClickListener {
//            option1.background = ContextCompat.getDrawable(this, R.drawable.selected_option)
//        }
//
//        progress_bar.progress = 1
//        progress_bar.max = questionList!!.size


        setQuestion()

        option1.setOnClickListener {
            selectedOptionStyle(option1, 1)
        }

        option2.setOnClickListener {
            selectedOptionStyle(option2, 2)
        }

        option3.setOnClickListener {
            selectedOptionStyle(option3, 3)
        }

        option4.setOnClickListener {
            selectedOptionStyle(option4, 4)
        }

        submit_button.setOnClickListener {
            if(selectedOption!=0) {
                val question = questionList!![currPosition-1]
                if(question.correct_ans!=selectedOption) {
                    setOptionColor(selectedOption, R.drawable.wrong_option_bg)
                } else {
                    score++
                }
                setOptionColor(question.correct_ans, R.drawable.correct_option_bg)
                if(currPosition == questionList!!.size)
                    submit_button.text = "Finish"
                else
                    submit_button.text = "Go to Next"
            } else {
                currPosition++
                when {
                    currPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        var intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(SetData.name, name.toString())
                        intent.putExtra(SetData.score, score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }

    }

    fun setOptionColor(option: Int, color: Int) {
        when(option) {
            1-> {
                option1.background = ContextCompat.getDrawable(this,color)
            }
            2-> {
                option2.background = ContextCompat.getDrawable(this,color)
            }
            3-> {
                option3.background = ContextCompat.getDrawable(this,color)
            }
            4-> {
                option4.background = ContextCompat.getDrawable(this,color)
            }
        }
    }

    fun setQuestion() {
        val ques = questionList!![currPosition-1]
        setOptionStyle()

        progress_bar.progress = currPosition
        progress_bar.max = questionList!!.size
        progress_text.text = "${currPosition}" + "/" + "${questionList!!.size}"

        tv_question.text = ques.question
        option1.text = ques.option_one
        option2.text = ques.option_two
        option3.text = ques.option_three
        option4.text = ques.option_four
    }

    fun setOptionStyle() {
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0, option1)
        optionList.add(1, option2)
        optionList.add(2, option3)
        optionList.add(3, option4)

        for(option in optionList) {
            option.setTextColor(Color.parseColor("#555151"))
            option.background = ContextCompat.getDrawable(this,R.drawable.option_bg)
            option.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, option: Int) {
        setOptionStyle()
        selectedOption = option
        view.background = ContextCompat.getDrawable(this,R.drawable.selected_option_bg)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}