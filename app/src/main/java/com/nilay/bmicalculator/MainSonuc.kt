
package com.nilay.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.nilay.bmicalculator.databinding.ActivityMainKayitOlBinding
import com.nilay.bmicalculator.databinding.ActivityMainSonucBinding

class MainSonuc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainSonucBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //intent'ten gelen veriler alınsın:
        val bmiSonuc = intent.getStringExtra("bmiSonuc")
        val bmiKategori = intent.getStringExtra("bmiKategori")

        //verileri textView'lara aktaralım:
        val bmiSonucText = findViewById<TextView>(R.id.bmiSonucText)
        val kategoriSonucText = findViewById<TextView>(R.id.kategoriSonucText)

        bmiSonucText.text = bmiSonuc
        kategoriSonucText.text = bmiKategori


        binding.btnSonuctanGirise.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // hosgeldiniz binding.btnSonuctanBilgilere.setOnClickListener {
           // val intent = Intent(this, MainHosgeldiniz::class.java)
          //  startActivity(intent)
       // }
    }
}
