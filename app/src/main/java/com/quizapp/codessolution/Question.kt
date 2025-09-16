package com.quizapp.codessolution

data class Question(
    val id: Int,
    val questions: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
