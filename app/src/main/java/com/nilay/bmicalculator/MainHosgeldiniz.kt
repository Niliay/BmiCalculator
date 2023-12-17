
package com.nilay.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.nilay.bmicalculator.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val binding = ActivityMainHosgeldinizBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Çıkış:
        binding.btnCikisYap.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Kullanıcı bilgisini al ve TextView'lara atama yap
        val kullaniciAdi = intent.getStringExtra("kullaniciAdi")
        val kullaniciParola = intent.getStringExtra("kullaniciParola")

        binding.endKullaniciAdi.text = kullaniciAdi
        binding.endKullaniciParola.text = kullaniciParola
    }
}