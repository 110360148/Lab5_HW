package com.example.lab5_hw_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var set_drink : EditText
    private lateinit var rg1 : RadioGroup
    private lateinit var rg2 : RadioGroup
    private lateinit var btn_send : Button
    private lateinit var sugar : String
    private lateinit var ice_opt : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rg1 = findViewById(R.id.radioGroup)
        rg1.setOnCheckedChangeListener { radioGroup: RadioGroup?, i: Int ->
            if (i == R.id.radioButton1) {
                sugar = "無糖"
            } else if (i == R.id.radioButton2) {
                sugar = "少糖"
            } else if (i == R.id.radioButton3) {
                sugar = "半糖"
            } else if (i == R.id.radioButton4) {
                sugar = "全糖"
            }
        }

        rg2 = findViewById(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener { radioGroup2: RadioGroup?, i: Int ->
            if (i == R.id.radioButton5) {
                ice_opt = "去冰"
            } else if (i == R.id.radioButton6) {
                ice_opt = "微冰"
            } else if (i == R.id.radioButton7) {
                ice_opt = "少冰"
            } else if (i == R.id.radioButton8) {
                ice_opt = "正常冰"
            }
        }

        btn_send = findViewById(R.id.btn_send)
        btn_send.setOnClickListener { view: View? ->
            set_drink = findViewById(R.id.ed_drink)
            val drink: String = set_drink.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("drink", drink)
            b.putString("sugar", sugar)
            b.putString("ice", ice_opt)
            i.putExtras(b)
            setResult(RESULT_OK, i)
            finish()
        }
    }
}