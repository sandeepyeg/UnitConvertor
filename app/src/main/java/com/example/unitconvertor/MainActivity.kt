package com.example.unitconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kgInput: EditText = findViewById(R.id.EnteredText)
        val conversionButton: Button = findViewById(R.id.ConvertorButton)
        val lbsOutput: TextView = findViewById(R.id.ResultView)

        conversionButton.setOnClickListener {
            val kgValue: String = kgInput.text.toString()

            if (kgValue.isNotBlank()) {
                val kgValueConverted: Double? = kgValue.toDoubleOrNull()

                if (kgValueConverted != null) {
                    val calculatedValue = conversionFromKgs(kgValueConverted)
                    val textConverted = "$calculatedValue lbs"
                    lbsOutput.text = textConverted
                } else {
                    lbsOutput.text = "Invalid input. Please enter a valid number."
                }
            } else {
                lbsOutput.text = "Please enter a value in kilograms."
            }
        }
    }

    private fun conversionFromKgs(value: Double): Double {
        return value * 2.20462
    }
}