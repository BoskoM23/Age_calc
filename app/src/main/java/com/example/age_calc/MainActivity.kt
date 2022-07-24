package com.example.age_calc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener { view ->
            printAge(view)
        }
    }

    private fun printAge(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        @Suppress("NAME_SHADOWING")
        DatePickerDialog(this, { view, year, month, day ->

            val selectedDate = "$day/${month + 1}/$year"

            val textView1 = findViewById<TextView>(R.id.textView1)
            textView1.text = selectedDate

            val dob = Calendar.getInstance()
            dob.set(year, month, day)

            var age = myCalendar.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
            if (myCalendar.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                age--
            }

            val textView2 = findViewById<TextView>(R.id.textView2)
            textView2.text = getString(R.string.you_are_this_old, age)

        }, year, month, day).show()
    }
}