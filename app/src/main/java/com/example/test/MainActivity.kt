package com.example.test

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etInput    = findViewById<EditText>(R.id.etInput)
        val tvResult   = findViewById<TextView>(R.id.tvResult)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val btnCopy    = findViewById<Button>(R.id.btnCopy)
        val rbUkr      = findViewById<RadioButton>(R.id.rbUkrainian)

        fun getLanguage() = if (rbUkr.isChecked)
            LayoutConverter.Language.UKRAINIAN
        else
            LayoutConverter.Language.RUSSIAN

        // Конвертація по кнопці
        btnConvert.setOnClickListener {
            val input = etInput.text.toString()
            if (input.isBlank()) {
                Toast.makeText(this, "Введи текст!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            tvResult.text = LayoutConverter.convert(input, getLanguage())
            btnCopy.visibility = View.VISIBLE
        }

        // Копіювати в буфер
        btnCopy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboard.setPrimaryClip(ClipData.newPlainText("converted", tvResult.text))
            Toast.makeText(this, "Скопійовано!", Toast.LENGTH_SHORT).show()
        }

        // Авто-конвертація під час набору
        etInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val input = s?.toString() ?: return
                if (input.isNotBlank()) {
                    tvResult.text = LayoutConverter.convert(input, getLanguage())
                    btnCopy.visibility = View.VISIBLE
                } else {
                    tvResult.text = ""
                    btnCopy.visibility = View.GONE
                }
            }
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
        })
    }
}