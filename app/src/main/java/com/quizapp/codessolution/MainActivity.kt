package com.quizapp.codessolution

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.quizapp.codessolution.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.StartBtn.setOnClickListener {
            if (binding.NameET.text.toString().isEmpty()){
                Toast.makeText(this@MainActivity,"Please Enter Your Name to Start The Quiz", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this@MainActivity,"${binding.NameET.text} You can Now Start The Quiz",Toast.LENGTH_SHORT).show()
            }
        }
    }
}