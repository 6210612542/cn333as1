package com.example.numberguessinggame

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageButtonReset: Button
    lateinit var imageButtonCheck: ImageButton


    var random: Int = nextInt(1,1000)
    var count: Int = 0


    @SuppressLint("SetTextI18n", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)

        imageButtonCheck = findViewById(R.id.imageButtonCheck)
        imageButtonReset = findViewById(R.id.playagain)

        textView.text = "Please Enter Your Guess"

        editText.setOnClickListener{
            editText.text.clear()
        }



        imageButtonCheck.setOnClickListener{

            val number: Int = editText.text.toString().toInt()

                if (number < random){
                    textView.text = "wrong your number is too low"
                    editText.text.clear()
                    count += 1

                }else if (number > random){
                    textView.text = "wrong your number is too much"
                    editText.text.clear()
                    count += 1

                }else{
                    textView.text = "correct!, the count that you guess: $count"
                    editText.text.clear()
            }

        }

        imageButtonReset.setOnClickListener {
            reset()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun reset(){
        random = nextInt(1,1000)
        textView.text = "Please Enter Your Guess"
        editText.text.clear()
        count = 0
    }
}
