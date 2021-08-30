package com.example.quizapp

object SetData {

    fun getQuestion(): ArrayList<QuestionData> {
        val ques: ArrayList<QuestionData> = arrayListOf()

        val q1 = QuestionData(
            "What is the capital of India?",
            1,
            "Kolkata",
            "Delhi",
            "Mumbai",
            "Ladakh",
            2
        )
        ques.add(q1)

        val q2 = QuestionData(
            "First Man to step on Moon?",
            1,
            "Neil Armstrong",
            "Kalpana Chawla",
            "Christopher Nolan",
            "Sunita Williams",
            1
        )
        ques.add(q2)

        val q3 = QuestionData(
            "Turing Machine was made by?",
            1,
            "Nikola Tesla",
            "Alan Turing",
            "Thomas Edition",
            "Alexandar Fleming",
            2
        )
        ques.add(q3)

        val q4 = QuestionData(
            "Amazon was founded by?",
            1,
            "Sundar Pichai",
            "Satya Nadella",
            "Jeff Bezos",
            "Bill Gates",
            3
        )
        ques.add(q4)

        val q5 = QuestionData(
            "Who was the first Indian woman in space?",
            1,
            "Sunita Williams",
            "Shirisha Bandla",
            "Sally Ride",
            "Kalpana Chawla",
            4
        )
        ques.add(q5)

        return ques
    }
}