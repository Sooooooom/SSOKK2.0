package com.example.ssokk20ex.ui.info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.ssokk20ex.MainActivity
import com.example.ssokk20ex.MyPage
import com.example.ssokk20ex.R

class InfoNorm4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_norm4)
        supportActionBar?.hide()

        var home = findViewById<Button>(R.id.homeBtn)
        home.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        var setting = findViewById<ImageButton>(R.id.setting)
        setting.setOnClickListener {
            startActivity(Intent(this, MyPage::class.java))
        }
    }
}
