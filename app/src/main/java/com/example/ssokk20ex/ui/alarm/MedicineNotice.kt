package com.example.ssokk20ex.ui.alarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ssokk20ex.R
import kotlinx.android.synthetic.main.activity_blood_sugar_notice.tab_blood_sugar
import kotlinx.android.synthetic.main.activity_blood_sugar_notice.tab_pill
import kotlinx.android.synthetic.main.activity_medicine_notice.*

class MedicineNotice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine_notice)
        supportActionBar?.hide()

        tab_blood_sugar.setOnClickListener {
            startActivity(Intent(this, AlarmFunctions::class.java))
        }

        tab_pill.setOnClickListener {
            startActivity(Intent(this, MedicineNotice::class.java))
        }

        btn_fixMedicineNotice.setOnClickListener {
            startActivity(Intent(this, AddMedicineNotice::class.java))
        }

        pillPlusBtn.setOnClickListener {
            startActivity(Intent(this, AddMedicineNotice::class.java))
        }
    }
}