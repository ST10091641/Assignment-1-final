package com.example.assignment1final

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mealInput: EditText
    private lateinit var resultText: TextView
    private lateinit var suggestButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealInput = findViewById(R.id.mealInput)
        resultText = findViewById(R.id.resultText)
        suggestButton = findViewById(R.id.suggestButton)

        suggestButton.setOnClickListener {
            val timeOfDay = mealInput.text.toString().trim().lowercase()
            val suggestion = getMealSuggestion(timeOfDay)

            if (suggestion != null) {
                resultText.text = "Suggested meal for $timeOfDay: $suggestion"
            } else {
                resultText.text = "⚠️ Invalid input. Please enter Morning, Snack, Afternoon, or Dinner."
            }
        }
    }

    private fun getMealSuggestion(timeOfDay: String): String? {
        return when (timeOfDay) {
            "morning" -> "Pancakes or Smoothie"
            "mid-morning" -> "Fruit and Yoghurt"
            "afternoon" -> "Sandwich or Salad"
            "afternoon snack" -> "Cookies and Milk"
            "dinner" -> "Pasta or Stir Fry"
            "after dinner" -> "Ice Cream or Fruit Salad"
            else -> null
        }
    }
}


