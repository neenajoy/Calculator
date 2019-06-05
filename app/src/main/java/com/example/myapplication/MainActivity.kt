package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    //make canClickOperator to false when symbols are clicked one after another
    var canClickOperator = true

    private val onClickListener = View.OnClickListener { view ->
        var txt = (view as TextView).text
        if (calc_text_view.text == "0") {

            if (txt == "*" || txt == "/" || txt == "^") {
                return@OnClickListener

            }
            if (txt == "+" || txt == "-") {
                canClickOperator = false

            }

            calc_text_view.text = ""
            calc_text_view.text = calc_text_view.text.toString() + (view as TextView).text
        } else {
            if (txt == "/" || txt == "*" || txt == "^" || txt == "." || txt == "+" || txt == "-") {
                if (canClickOperator == false) {
                    return@OnClickListener
                }
                canClickOperator = false

            } else {
                canClickOperator = true
            }

            calc_text_view.text = calc_text_view.text.toString() + (view as TextView).text

        }
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
        multiply_text_view.setOnClickListener(onClickListener)
        divide_text_view.setOnClickListener(onClickListener)
        decimal_text_view.setOnClickListener { onClickListener }

        equal_text_view.setOnClickListener {

            var expression = calc_text_view.text
            var nextBlock = ""
            val symbolList: MutableList<Char> = ArrayList()
            val numbersList: MutableList<Float> = ArrayList()


            for (char in expression) {
                if (char == '+' || char == '-' || char == '*' || char == '/') {
                    symbolList.add(char)
                    numbersList.add(nextBlock.toFloat())
                    nextBlock = ""
                } else {
                    nextBlock += char

                }

            }
            numbersList.add(nextBlock.toFloat())
//
//            val operationList = arrayListOf('^', '/', '*', '+', '-')
//            var result = 0.00f
//            for (operation in operationList) {
//                for (symbol in symbolList) {
//                    if (symbol == operation) {
//                        var position = symbolList.indexOf(symbol)
//
//                        var firstOperand = numbersList.get(position)
//                        var secondOperand = numbersList.get(position + 1)
//                        //     var result = 0.00
//
//                        when (symbol) {
//                            '+' -> result = firstOperand + secondOperand
//                            '-' -> result = firstOperand - secondOperand
//                            '*' -> result = firstOperand * secondOperand
//                            '/' -> result = firstOperand / secondOperand
////                            '^' -> result = Math.pow(firstOperand.toDouble(),secondOperand.)
//                        }
//                        numbersList.set(position, result)
//                        numbersList.removeAt(position + 1)
//                        symbolList.removeAt(position)
//                    }
//                }
//
//            }
//            result_text_view.text = result.toString()
//        }
//
//    }
//}

            val operationList = arrayListOf('^', '/', '*', '+', '-')

          //  val iterator = symbolList.listIterator()
            var result = 0.00f
            for (operation in operationList) {
                for(symbol in symbolList) {

                    if (symbol == operation) {
                        var position = symbolList.indexOf(symbol)

                        var firstOperand = numbersList.get(position)
                        var secondOperand = numbersList.get(position + 1)
                        //     var result = 0.00

                        when (symbol) {
                            '+' -> result = firstOperand + secondOperand
                            '-' -> result = firstOperand - secondOperand
                            '*' -> result = firstOperand * secondOperand
                            '/' -> result = firstOperand / secondOperand
//                            '^' -> result = Math.pow(firstOperand.toDouble(),secondOperand.)
                        }
                        numbersList.set(position, result)
                        numbersList.removeAt(position + 1)
                        symbolList.removeAt(position)
                    }
                }

            }
            result_text_view.text = result.toString()
        }

    }
}







