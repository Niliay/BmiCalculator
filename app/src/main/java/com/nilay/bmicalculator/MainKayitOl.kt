package com.nilay.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.nilay.bmicalculator.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kayıt olma aşaması:
        binding.btnKaydet.setOnClickListener {
            // Veri alma:
            val kullaniciBilgisi = binding.kayitKullaniciAdi.text.toString()
            val kullaniciParola = binding.kayitParola.text.toString()

            // Gerekli alanların dolu olup olmadığını kontrol et
            if (kullaniciBilgisi.isEmpty() || kullaniciParola.isEmpty()) {
                Toast.makeText(applicationContext, "Lütfen gerekli alanları doldurun", Toast.LENGTH_LONG).show()
            } else {
                // Alınan verileri XML dosyasına kaydetme:
                val sharedPreferences = this.getSharedPreferences("bilgiler", MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                // Veri ekleme: ("$")
                editor.putString("kullanici", kullaniciBilgisi).apply()
                editor.putString("parola", kullaniciParola).apply()

                Toast.makeText(applicationContext, "Kayıt Başarılı!", Toast.LENGTH_LONG).show()
                binding.kayitKullaniciAdi.text.clear()
                binding.kayitParola.text.clear()
            }
        }

        binding.btnGiriseDN.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }
}