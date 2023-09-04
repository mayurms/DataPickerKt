package com.example.datapickerkt

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

private lateinit var textdate: TextView
private lateinit var buttonDate: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textdate = findViewById(R.id.textDate)
        buttonDate = findViewById(R.id.buttonDate)

        val calendarBox =Calendar.getInstance()
        val dateBox = DatePickerDialog.OnDateSetListener{ view: DatePicker?, year: Int, month: Int,
                                            dayOfMonth: Int ->
            calendarBox.set(Calendar.YEAR, year)
            calendarBox.set(Calendar.MONTH,month)
            calendarBox.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateText(calendarBox)
        }
        buttonDate.setOnClickListener{
            DatePickerDialog(
                this,dateBox,calendarBox.get(Calendar.YEAR),
                calendarBox.get(Calendar.MONTH),
                calendarBox.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun updateText(calender: Calendar) {
        val dateFormat = "dd-MM-yyyy"
        val sdf =SimpleDateFormat(dateFormat, Locale.UK)
        textdate.setText(sdf.format(calender.time))

    }
}