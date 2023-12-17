package com.nilay.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nilay.bmicalculator.databinding.ActivityMainSecBinding

class MainSec : AppCompatActivity() {

    private lateinit var binding: ActivityMainSecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainSecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCinsiyet.setOnClickListener {
            // Seçili olan RadioButton'ı kontrol et
            val selectedRadioButtonId = binding.RadioGroup.checkedRadioButtonId

            if (selectedRadioButtonId == -1) {
                // Hiçbir RadioButton seçili değilse kullanıcıyı uyar
                Toast.makeText(this, "Cinsiyet seçiniz!", Toast.LENGTH_SHORT).show()
            } else {
                // RadioButton seçili ise cinsiyeti belirle ve MainBmi aktivitesine geçiş yap
                val intent = Intent(this, MainHesapla::class.java)
                when (selectedRadioButtonId) {
                    R.id.rKadin -> {
                        // Kadın seçildi
                        intent.putExtra("Cinsiyet", "Kadın")
                    }
                    R.id.rErkek -> {
                        // Erkek seçildi
                        intent.putExtra("Cinsiyet", "Erkek")
                    }
                }
                startActivity(intent)
            }
        }
    }
}
