package com.example.a10dchalenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val tvResult :TextView = findViewById(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textviewClassificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)
        tvResult.text= result.toString()

        var classificacao = if(result<18.5f){
            "Abaixo do peso"
        }else if(result in 18.5f..24.9f){
          "normal"
        }else if(result in 25f..29.9f){
            "sobrepeso"
        }else if(result in 30f..39.9f){
           "obesidade"
        }else{
            "obesidade grave"
        }


        tvClassificacao.text=getString(R.string.message_classificacao,classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}