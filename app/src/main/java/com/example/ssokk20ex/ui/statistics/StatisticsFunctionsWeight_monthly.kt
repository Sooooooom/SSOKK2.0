package com.example.ssokk20ex.ui.statistics

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.ssokk20ex.MainActivity
import com.example.ssokk20ex.MyPage
import com.example.ssokk20ex.R
import com.example.ssokk20ex.ui.statistics.StatisticsFunctionsWeight.Companion.isChecked_monthly_weight
import com.example.ssokk20ex.ui.statistics.StatisticsFunctionsWeight.Companion.isChecked_weekly_weight
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.android.synthetic.main.blood_sugar_record_weekly.allRecordBtn
import kotlinx.android.synthetic.main.blood_sugar_record_weekly.bloodSugarStatisticsBtn
import kotlinx.android.synthetic.main.weight_record_weekly.*

class StatisticsFunctionsWeight_monthly : AppCompatActivity() {

    private val entries = ArrayList<Entry>()
    var chart : LineChart? = null

    val stat = StatisticsFunctionsWeight()

    var xAxisValues: List<String> = java.util.ArrayList(
        listOf(
            "첫째주", "둘째주", "셋째주", "넷째주"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weight_record_weekly)
        supportActionBar?.hide()

        weeklyBtn_bmi.setImageResource(R.drawable.weekly)
        monthlyBtn_bmi.setImageResource(R.drawable.monthly_clicked)

        chart = findViewById<LineChart>(R.id.bmiGraph)

        highestWeubg_value.text = String.format("%.2f", stat.getBMI("2020-1-18"))
        averageWeight_value.text = String.format("%.2f", stat.getBMI("2020-1-15"))
        lowestWeight_value.text = String.format("%.2f", stat.getBMI("2020-1-16"))

        drawBmiChart()

        home_stat_weight.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        var setting = findViewById<ImageButton>(R.id.setting)
        setting.setOnClickListener {
            startActivity(Intent(this, MyPage::class.java))
        }

        weeklyBtn_bmi.setOnClickListener {
            isChecked_weekly_weight = true
            isChecked_monthly_weight = false
            startActivity(Intent(this, StatisticsFunctionsWeight::class.java))
        }

        bloodSugarStatisticsBtn.setOnClickListener {
            startActivity(Intent(this, StatisticsFunctions::class.java))
        }

        allRecordBtn.setOnClickListener {
            startActivity(Intent(this,StatisticsFunctions_AllRecord::class.java))
        }
    }

    private fun drawBmiChart() {
        entries.add(Entry(0f, stat.getBMI("2020-1-14")))
        entries.add(Entry(1f, stat.getBMI("2020-1-16")))
        entries.add(Entry(2f, stat.getBMI("2020-1-18")))
        entries.add(Entry(3f, stat.getBMI("2020-1-20")))

        val dataSet = LineDataSet(entries, "BMI")
        dataSet.lineWidth = 2f
        dataSet.circleRadius = 3f
        dataSet.setCircleColor(Color.parseColor("#f16161"))
        dataSet.color = Color.parseColor("#f16161")
        dataSet.setDrawCircleHole(false)
        val lineData = LineData(dataSet)
        chart!!.data = lineData

        val xAxis: XAxis = chart!!.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)

        val yAxisLeft: YAxis = chart!!.axisLeft
        yAxisLeft.granularity = 1f
        yAxisLeft.setDrawGridLines(false)

        val yAxisRight: YAxis = chart!!.axisRight
        yAxisRight.isEnabled = false

        chart!!.legend.isEnabled = false
        chart!!.description.isEnabled = false

        chart!!.invalidate()
    }
}