package com.quizapp.codessolution

class Constant {
    fun getQuestions() : ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What is the Capital of Pakistan?",
            "Lahore",
            "Peshawar",
            "Islamabad",
            "Karachi",
            3
        )
        questionList.add(que1)
        val que2 = Question(
            1,
            "What is the Capital of Pakistan?",
            "Lahore",
            "Peshawar",
            "Islamabad",
            "Karachi",
            3
        )
        questionList.add(que2)
        val que3 = Question(
            1,
            "What is the Capital of Pakistan?",
            "Lahore",
            "Peshawar",
            "Islamabad",
            "Karachi",
            3
        )
        questionList.add(que3)

        return questionList

    }
}