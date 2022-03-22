package com.wht3v3r.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun NumAct(view: View) {
        var value: String? = null
        var box1 : TextView = findViewById(R.id.box1)
        if (box1.text.toString().length > 12) return
        when(view.id) {
            R.id.but1 -> value = "1"
            R.id.but2 -> value = "2"
            R.id.but3 -> value = "3"
            R.id.but4 -> value = "4"
            R.id.but5 -> value = "5"
            R.id.but6 -> value = "6"
            R.id.but7 -> value = "7"
            R.id.but8 -> value = "8"
            R.id.but9 -> value = "9"
            R.id.but0 -> value = "0"
            R.id.but00 -> {
                value = if (box1.text.equals("0")) "0"
                else "00"
            }
        }

        if (box1.text.toString().toDouble() == 0.toDouble() && !box1.text.contains(".")){
            box1.setText(value)
        } else  {
            box1.setText("${box1.text}${value}")
        }
    }

    fun OprAct(view: View) {
        var value: String? = null
        var opr : TextView = findViewById(R.id.opr)
        var box1 : TextView = findViewById(R.id.box1)
        var box2 : TextView = findViewById(R.id.box2)
        when(view.id) {
            R.id.add -> value = "+"
            R.id.sub -> value = "–"
            R.id.mul -> value = "✕"
            R.id.div -> value = "÷"
            R.id.perc -> value = "%"
            R.id.pnt -> {
                if(box1.text.contains(".")) return
                else {
                    box1.setText("${box1.text}.")
                    return
                }
            }
            R.id.reset -> {
                box1.setText("0")
                box2.setText("")
                opr.setText("")
                return
            }
            R.id.backSpace -> {
                if(box1.text.toString() == "0 ") {
                    return
                } else if(box1.text.toString().length == 1) {
                    box1.setText("0")
                    return
                } else  {
                    box1.setText(box1.text.toString().dropLast(1))
                    return
                }
            }
        }
        if (box1.text.toString() == "0") return
        if (box2.text.length == 0) {
            box2.setText(box1.text)
            opr.setText(value)
            box1.setText("0")
        }
    }

    fun result(view: View) {
        var opr : TextView = findViewById(R.id.opr)
        var box1 : TextView = findViewById(R.id.box1)
        var box2 : TextView = findViewById(R.id.box2)

        if(opr.text.contains("+")) {
            var ans = box1.text.toString().toBigDecimal() + box2.text.toString().toBigDecimal()
            box1.setText(ans.toString())
            box2.setText("")
            opr.setText("")
        }
        if(opr.text.contains("–")) {
            var ans = box2.text.toString().toBigDecimal() - box1.text.toString().toBigDecimal()
            box1.setText(ans.toString())
            box2.setText("")
            opr.setText("")
        }
        if(opr.text.contains("✕")) {
            var ans = box1.text.toString().toBigDecimal() * box2.text.toString().toBigDecimal()
            box1.setText(ans.toString())
            box2.setText("")
            opr.setText("")
        }
        if(opr.text.contains("÷")) {
            var ans = box2.text.toString().toDouble() / box1.text.toString().toDouble()
            box1.setText(ans.toString())
            box2.setText("")
            opr.setText("")
        }
        if(opr.text.contains("%")) {
            var ans = box2.text.toString().toDouble() / box1.text.toString().toDouble()
            box1.setText((ans.toDouble()*100).toString())
            box2.setText("")
            opr.setText("")
        }

    }

}