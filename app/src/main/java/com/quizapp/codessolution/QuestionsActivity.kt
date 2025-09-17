package com.quizapp.codessolution

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.quizapp.codessolution.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuestionsBinding
    var mCurrentPosition : Int = 1
    private var mQuesitonList : ArrayList<Question> = arrayListOf()
    private var mSelectOption : Int  = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mQuesitonList = Constant.getQuestions()
        binding.progressBar2.max = mQuesitonList.size
        var name = intent.getStringExtra("Name")
        binding.NameTv.text = "Hello Mr.$name, Your Quiz is Loaded."
        setQuestions()
        binding.OptionATV.setOnClickListener{CheckAnswer(1,binding.OptionATV)}
        binding.OptionBTV.setOnClickListener{CheckAnswer(2,binding.OptionBTV)}
        binding.OptionCTV.setOnClickListener{CheckAnswer(3,binding.OptionCTV)}
        binding.OptionDTV.setOnClickListener{CheckAnswer(4,binding.OptionDTV)}

        //github.com/Naseer122
        binding.btnNext.setOnClickListener {
                    if (mCurrentPosition < mQuesitonList.size){
                        mCurrentPosition++
                        setQuestions()
                    } else{
                        Toast.makeText(this,"Your Quiz is Finished",Toast.LENGTH_SHORT).show()
                    }

        }





    }

    private fun setQuestions() {
        val question = mQuesitonList[mCurrentPosition -1]
        mSelectOption = 0
        resetBackground()
        binding.QuesionTv.text = question.questions
        binding.OptionATV.text = question.optionOne
        binding.OptionBTV.text = question.optionTwo
        binding.OptionCTV.text = question.optionThree
        binding.OptionDTV.text = question.optionFour
        binding.progressBar2.progress = mCurrentPosition
        binding.tvProgress.text = "${mCurrentPosition}/${mQuesitonList.size}"
    }

    private fun resetBackground(){
        val defaultbg = ContextCompat.getDrawable(this,R.drawable.optionbackroud)
        binding.OptionATV.background = defaultbg
        binding.OptionBTV.background = defaultbg
        binding.OptionCTV.background = defaultbg
        binding.OptionDTV.background = defaultbg
    }

    private fun CheckAnswer(selectedOption : Int,selectedTextView: TextView){

        if (mSelectOption !=0) return
        mSelectOption = selectedOption

        val question = mQuesitonList[mCurrentPosition -1]
        if(selectedOption == question.correctAnswer){
            selectedTextView.background = ContextCompat.getDrawable(this,R.drawable.correctbg)
        }else{
            selectedTextView.background = ContextCompat.getDrawable(this,R.drawable.wrongbg)
        }

        when(question.correctAnswer){
            1 -> binding.OptionATV.background = ContextCompat.getDrawable(this,R.drawable.correctbg)
            2 -> binding.OptionBTV.background = ContextCompat.getDrawable(this,R.drawable.correctbg)
            3 -> binding.OptionCTV.background = ContextCompat.getDrawable(this,R.drawable.correctbg)
            4 -> binding.OptionDTV.background = ContextCompat.getDrawable(this,R.drawable.correctbg)
        }



    }

}