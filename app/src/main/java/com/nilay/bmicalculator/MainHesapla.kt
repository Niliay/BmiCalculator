package com.nilay.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nilay.bmicalculator.databinding.ActivityMainHesaplaBinding

class MainHesapla : AppCompatActivity() {
    private lateinit var binding: ActivityMainHesaplaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHesaplaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHesapla.setOnClickListener {
            hesapla()
        }
    }

    private  fun hesapla(){
        val agirlik = binding.agirlikEdit.text.toString().toFloatOrNull()
        val boy = binding.boyEdit.text.toString().toFloatOrNull()

        if((agirlik != null) && (boy != null)){
            val bmi = (agirlik) / ((boy/100)*(boy/100))
            val bmiSonuc = String.format("%.2f", bmi)

            val bmiKategori = when {
                bmi < 18.5  -> "İdeal kilonuzun altındasınız"
                ((bmi < 25) && (bmi>=18.5)) -> "İdeal kilodasınız"
                ((bmi < 30) && (bmi >= 25)) -> "İdeal kilonuzun üzerinesiniz"
                ((bmi < 40) && (bmi >=30)) -> "İdeal kilonuzun çok üzerindesiniz(obez)"
                else -> "İdeal kilonuzun çok üstündesiniz(morbid obez)"
            }

            val intent = Intent(this, MainSonuc::class.java)
            intent.putExtra("bmiSonuc", bmiSonuc)
            intent.putExtra("bmiKategori", bmiKategori)

            //mainsonuc başlatılsın:
            startActivity(intent)

        }
    }
}
