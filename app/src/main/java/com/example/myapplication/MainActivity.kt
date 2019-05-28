package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    var x = 5

    private val onClickListener = View.OnClickListener { view ->
        if (calc_text_view.text == "0") {
            calc_text_view.text = ""
            calc_text_view.text = calc_text_view.text.toString() + (view as TextView).text
        } else
            calc_text_view.text = calc_text_view.text.toString() + (view as TextView).text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one_text_view.setOnClickListener(onClickListener)
        two_text_view.setOnClickListener(onClickListener)
        three_text_view.setOnClickListener(onClickListener)
        four_text_view.setOnClickListener(onClickListener)
        five_text_view.setOnClickListener(onClickListener)
        six_text_view.setOnClickListener(onClickListener)
        seven_text_view.setOnClickListener(onClickListener)
        eight_text_view.setOnClickListener(onClickListener)
        nine_text_view.setOnClickListener(onClickListener)
        zero_text_view.setOnClickListener(onClickListener)
        clear_text_view.setOnClickListener {
            calc_text_view.setText("0")
            result_text_view.setText("0")
        }
        plus_text_view.setOnClickListener(onClickListener)
        minus_text_view.setOnClickListener(onClickListener)

        equal_text_view.setOnClickListener {
            //            var result = 0
//            var nextBlock = ""
//            var operation = 'a'
//            calc_text_view.text.forEach { char ->
//                if (char == '+') {
//                    operation = '+'
//                    result += nextBlock.toInt()
//                    nextBlock = ""
//
//                } else if (char == '-') {
//                    operation = '-'
//                    if (result == 0) {
//                        result += nextBlock.toInt()
//                    } else {
//                        result -= nextBlock.toInt()
//                    }
//                    nextBlock = ""
//                } else {
//
//                    nextBlock += char
//                }
//
//            }
//            if (operation == '+') {
//                result += nextBlock.toInt()
//
//            } else if (operation == '-') {
//                result -= nextBlock.toInt()
//            }
////
////
//
//            result_text_view.text = result.toString()

            var expression = calc_text_view.text
            var nextBlock=""
            val symbolList = arrayListOf<Char>()
            val numbersList = arrayListOf<Int>()
            expression.forEach { char ->
                if (char == '+' || char == '-' || char == '*' || char == '/') {
                    symbolList.add(char)
                    numbersList.add(nextBlock.toInt())
                    nextBlock=""
                } else {
                    nextBlock+=char

                }

            }

            val operationList = arrayListOf('^', '/', '*', '+', '_')
            operationList.forEach { operation->
                symbolList.forEach {symbol->
                    if (symbol==operation)
                    {
                        var position=symbolList.indexOf(symbol)

                        numbersList.get(position)
                    }
                }

            }

        }


    }
}




