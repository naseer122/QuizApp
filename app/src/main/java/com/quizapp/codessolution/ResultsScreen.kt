package com.quizapp.codessolution

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.quizapp.codessolution.databinding.ActivityResultsScreenBinding

class ResultsScreen : AppCompatActivity() {
    lateinit var binding : ActivityResultsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var Name = intent.getStringExtra("name")
        var CorrectAns = intent.getIntExtra("correctAnsw",0)
        var TotalQues = intent.getIntExtra("totalQues",0)

        var percantage = (CorrectAns * 100)/TotalQues

        binding.ResultsTv.text = "$Name\n"
        binding.ResultsTv.append("Your Score is $CorrectAns out of $TotalQues\n")
        binding.ResultsTv.append("Your Percentage is $percantage%")





    }
}