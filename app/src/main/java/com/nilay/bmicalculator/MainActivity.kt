package com.nilay.bmicalculator

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nilay.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)

        binding.btnGirisYap.setOnClickListener {
            // Kayıtlı kullanıcı bilgilerini alalım:
            val kayitliKullanici = preferences.getString("kullanici", "")
            val kayitliParola = preferences.getString("parola", "")

            // Giriş ekranındaki kullanıcı bilgilerini alalım:
            val girisKullanici = binding.girisKullaniciAdi.text.toString()
            val girisParola = binding.girisParola.text.toString()

            // Bilgilerin doğruluğunu kontrol et
            if (kayitliKullanici == girisKullanici && kayitliParola == girisParola) {
                // Doğruysa bir sonraki sayfaya geç
                val intent = Intent(this, MainSec::class.java)
                startActivity(intent)
            } else {
                // Hatalı bilgi durumunda kullanıcıyı bilgilendir
                Toast.makeText(applicationContext, "Giriş bilgileri hatalı!", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnKayitOl.setOnClickListener {
            val intent = Intent(this, MainKayitOl::class.java)
            startActivity(intent)
        }
    }
}

