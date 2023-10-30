package com.example.MAD_Assignment_2_21012011103

import android.os.Bundle
import android.text.Editable
import android.text.Selection
import android.text.method.ScrollingMovementMethod
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.MAD_Assignment_2_21012011103.R
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException
import java.util.EmptyStackException


class MainActivity : AppCompatActivity() {

    private lateinit var button_clear: android.widget.Button
    private lateinit var button_sin: android.widget.Button
    private lateinit var button_cos: android.widget.Button
    private lateinit var button_tan: android.widget.Button
    private lateinit var button_natural_log: android.widget.Button
    private lateinit var button_open_bracket: android.widget.Button
    private lateinit var button_close_bracket: android.widget.Button
    private lateinit var button_inverse: android.widget.Button
    private lateinit var button_square: android.widget.Button
    private lateinit var button_exponential: android.widget.Button
    private lateinit var button_add: android.widget.Button
    private lateinit var button_subtract: android.widget.Button
    private lateinit var button_multiply: android.widget.Button
    private lateinit var button_divide: android.widget.Button
    private lateinit var button_euler: android.widget.Button
    private lateinit var button_backspace: android.widget.Button
    private lateinit var button_pi: android.widget.Button
    private lateinit var button_under_root: android.widget.Button
    private lateinit var button_period: android.widget.Button
    private lateinit var button_equals: android.widget.Button

    private lateinit var button_one: android.widget.Button
    private lateinit var button_two: android.widget.Button
    private lateinit var button_three: android.widget.Button
    private lateinit var button_four: android.widget.Button
    private lateinit var button_five: android.widget.Button
    private lateinit var button_six: android.widget.Button
    private lateinit var button_seven: android.widget.Button
    private lateinit var button_eight: android.widget.Button
    private lateinit var button_nine: android.widget.Button
    private lateinit var button_zero: android.widget.Button

    private lateinit var input_display:EditText
    private lateinit var result_display: TextView

    private var operator_check: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button_clear        = findViewById(R.id.button_clear)
        button_sin          = findViewById(R.id.button_sin)
        button_cos          = findViewById(R.id.button_cos)
        button_tan          = findViewById(R.id.button_tan)
        button_natural_log  = findViewById(R.id.button_natural_log )
        button_open_bracket = findViewById(R.id.button_open_bracket)
        button_close_bracket= findViewById(R.id.button_close_bracket)
        button_inverse      = findViewById(R.id.button_inverse)
        button_square       = findViewById(R.id.button_square)
        button_exponential  = findViewById(R.id.button_exponential)
        button_add          = findViewById(R.id.button_add)
        button_subtract     = findViewById(R.id.button_subtract)
        button_multiply     = findViewById(R.id.button_multiply)
        button_divide       = findViewById(R.id.button_divide)
        button_backspace     = findViewById(R.id.button_backspace)
        button_pi           = findViewById(R.id.button_pi)
        button_under_root   = findViewById(R.id.button_under_root)
        button_period       = findViewById(R.id.button_period)
        button_euler        = findViewById(R.id.button_euler)
        button_equals       = findViewById(R.id.button_equals)

        button_one          = findViewById(R.id.button_one)
        button_two          = findViewById(R.id.button_two )
        button_three        = findViewById(R.id.button_three)
        button_four         = findViewById(R.id.button_four )
        button_five         = findViewById(R.id.button_five )
        button_six          = findViewById(R.id.button_six )
        button_seven        = findViewById(R.id.button_seven)
        button_eight        = findViewById(R.id.button_eight)
        button_nine         = findViewById(R.id.button_nine )
        button_zero         = findViewById(R.id.button_zero )

        input_display       = findViewById(R.id.input_display)
        result_display      = findViewById(R.id.result_display)

        input_display.movementMethod = ScrollingMovementMethod()
        input_display.isActivated = true
        input_display.isPressed = true

        var expression: String
        var bracket_check: Int = 0

        button_add.setOnClickListener{
            if(input_display.text.isEmpty()) showToast("Invalid Format")
            else if (input_display.text.last() == '(') showToast("Invalid Format")
            else if (input_display.text.last() == '/') showToast("Invalid Format")
            else if (input_display.text.last() == '.') showToast("Invalid Format")
            else {
                expression = input_display.text.toString() + "+"
                input_display.setText(expression)
                operator_check += 1
                resetCursorPosition()
            }
        }

        button_subtract.setOnClickListener{
            if(input_display.text.isEmpty()) {
                expression = input_display.text.toString() + "-"
                input_display.setText(expression)
                //operator_check += 1
                resetCursorPosition()
            }
            else if (input_display.text.last() == '(') showToast("Invalid Format")
            else if (input_display.text.last() == '/') showToast("Invalid Format")
            else if (input_display.text.last() == '.') showToast("Invalid Format")
            else {
                expression = input_display.text.toString() + "-"
                input_display.setText(expression)
                operator_check += 1
                resetCursorPosition()
            }
        }

        button_multiply.setOnClickListener{
            if(input_display.text.isEmpty()) showToast("Invalid Format")
            else if (input_display.text.last() == '(') showToast("Invalid Format")
            else if (input_display.text.last() == '/') showToast("Invalid Format")
            else if (input_display.text.last() == '.') showToast("Invalid Format")
            else {
                expression = input_display.text.toString() + "*"
                input_display.setText(expression)
                operator_check += 1
                resetCursorPosition()
            }
        }

        button_divide.setOnClickListener{
            if(input_display.text.isEmpty()) showToast("Invalid Format")
            else if (input_display.text.last() == '(') showToast("Invalid Format")
            else if (input_display.text.last() == '/') showToast("Invalid Format")
            else if (input_display.text.last() == '.') showToast("Invalid Format")
            else {
                expression = input_display.text.toString() + "/"
                input_display.setText(expression)
                operator_check += 1
                resetCursorPosition()
            }
        }

        button_sin.setOnClickListener{
            expression = input_display.text.toString() + "sin("
            input_display.setText(expression)
            bracket_check += 1
            resetCursorPosition()
        }

        button_cos.setOnClickListener{
            expression = input_display.text.toString() + "cos("
            input_display.setText(expression)
            bracket_check += 1
            resetCursorPosition()
        }

        button_tan.setOnClickListener{
            expression = input_display.text.toString() + "tan("
            input_display.setText(expression)
            bracket_check+=1
            resetCursorPosition()
        }

        button_natural_log.setOnClickListener{
            expression = input_display.text.toString() + "log("
            input_display.setText(expression)
            bracket_check+=1
            resetCursorPosition()
        }

        button_square.setOnClickListener{
            if(input_display.text.isEmpty()) showToast("Invalid Format")
            else if (input_display.text.last() == '(') showToast("Invalid Format")
            else if (input_display.text.last() == '/') showToast("Invalid Format")
            else if (input_display.text.last() == '.') showToast("Invalid Format")
            else{
                expression = input_display.text.toString() + "^2"
                input_display.setText(expression)
                resetCursorPosition()
                if (bracket_check == 0) calculate(expression)
            }
        }

        button_exponential.setOnClickListener{
            if(input_display.text.isNotEmpty()){
                if (input_display.text.last() == '.') showToast("Invalid Format")
                expression = input_display.text.toString() + "e^"
            }
            else{
                expression = input_display.text.toString() + "e^"
            }
            input_display.setText(expression)
            resetCursorPosition()
        }

        button_inverse.setOnClickListener{
            if(input_display.text.isNotEmpty()){
                if (input_display.text.last() == '.') showToast("Invalid Format")
                expression = input_display.text.toString() + "*(1/"
                bracket_check += 1
            }
            else{
                expression = input_display.text.toString() + "1/"
            }
            input_display.setText(expression)
            resetCursorPosition()
        }

        button_euler.setOnClickListener{
            if(input_display.text.isEmpty()) {
                expression = input_display.text.toString() + "e"
                input_display.setText(expression)
                operator_check -= 1
                if (bracket_check == 0) calculate(expression)
            }
            else if (input_display.text.last() == '.') showToast("Invalid Format")

            else{
                expression = input_display.text.toString() + "e"
                input_display.setText(expression)
                operator_check -= 1
                resetCursorPosition()
                if (bracket_check == 0) calculate(expression)
            }
        }

        button_pi.setOnClickListener{
            if(input_display.text.isEmpty()) {
                expression = input_display.text.toString() + "π"
                input_display.setText(expression)
                operator_check -= 1
                if (bracket_check == 0) calculate(expression)
            }
            else if (input_display.text.last() == '.') showToast("Invalid Format")

            else{
                expression = input_display.text.toString() + "π"
                input_display.setText(expression)
                operator_check -= 1
                resetCursorPosition()
                if (bracket_check == 0) calculate(expression)
            }
        }

        button_under_root.setOnClickListener{
            if(input_display.text.isEmpty()) {
                expression = input_display.text.toString() + "sqrt("
                input_display.setText(expression)
                bracket_check += 1
                if (bracket_check == 0) calculate(expression)
            }
            else if (input_display.text.last() == '.') showToast("Invalid Format")
            else{
                expression = input_display.text.toString() + "sqrt("
                input_display.setText(expression)
                bracket_check += 1
                resetCursorPosition()
                if (bracket_check == 0) calculate(expression)
            }
        }

        button_open_bracket.setOnClickListener{
            if(input_display.text.isEmpty()) showToast("Invalid Format")
            else if (input_display.text.last() == '.') showToast("Invalid Format")
            else {
                expression = input_display.text.toString() + "("
                input_display.setText(expression)
                bracket_check += 1
                resetCursorPosition()
            }
        }

        button_close_bracket.setOnClickListener{
            if(input_display.text.isEmpty()) showToast("Invalid Format")
            else if (input_display.text.last() == '(') showToast("Invalid Format")
            else if (input_display.text.last() == '/') showToast("Invalid Format")
            else if (input_display.text.last() == '.') showToast("Invalid Format")
            else{
                expression = input_display.text.toString() + ")"
                input_display.setText(expression)
                bracket_check -= 1
                resetCursorPosition()
                if (bracket_check == 0) calculate(expression)
            }
        }

        button_period.setOnClickListener{
            if(input_display.text.isNotEmpty()){
                expression = input_display.text.toString() + "."
            }
            else{
                expression = input_display.text.toString() + "0."
            }
            input_display.setText(expression)
            resetCursorPosition()
        }

        button_one.setOnClickListener{
            expression = input_display.text.toString() + "1"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_two.setOnClickListener{
            expression = input_display.text.toString() + "2"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_three.setOnClickListener{
            expression = input_display.text.toString() + "3"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_four.setOnClickListener{
            expression = input_display.text.toString() + "4"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_five.setOnClickListener{
            expression = input_display.text.toString() + "5"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_six.setOnClickListener{
            expression = input_display.text.toString() + "6"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_seven.setOnClickListener{
            expression = input_display.text.toString() + "7"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_eight.setOnClickListener{
            expression = input_display.text.toString() + "8"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_nine.setOnClickListener{
            expression = input_display.text.toString() + "9"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }
        button_zero.setOnClickListener{
            expression = input_display.text.toString() + "0"
            input_display.setText(expression)
            operator_check -= 1
            resetCursorPosition()
            if (bracket_check == 0) calculate(expression)
        }

        button_equals.setOnClickListener{
            expression = result_display.text.toString()
            input_display.setText(expression)
            result_display.text = null

            if(input_display.text == null){
                expression = input_display.text
                if (bracket_check == 0) calculate(expression)
            }
            operator_check = -1
            bracket_check = 0
        }

        button_clear.setOnClickListener{
            input_display.text = null
            result_display.text = null

            operator_check = 0
            bracket_check = 0
        }

        button_backspace.setOnClickListener{
            var edited_expression:String? = null

            if(input_display.text.isNotEmpty()){
                val stringBuilder: StringBuilder = StringBuilder(input_display.text)
                var expression = input_display.text.toString()
                val last_char = expression.last()

                if((last_char == 'y')){
                    stringBuilder.clear()
                }
                else if(expression.startsWith('-')){
                    stringBuilder.deleteCharAt(input_display.text.length-1)
                }
                else if((last_char == '+') or (last_char == '-') or (last_char == '*') or (last_char == '/')){
                    stringBuilder.deleteCharAt(input_display.text.length-1)
                    operator_check -= 1
                    edited_expression = stringBuilder.toString()
                    calculate(edited_expression)
                }
                else if(last_char == ')'){
                    stringBuilder.deleteCharAt(input_display.text.length-1)
                    bracket_check += 1
                }
                else if(last_char == '('){
                    stringBuilder.deleteCharAt(input_display.text.length-1)
                    bracket_check -= 1
                }
                else if(last_char == '^'){
                    stringBuilder.deleteCharAt(input_display.text.length-1)
                    stringBuilder.deleteCharAt(input_display.text.length-2)
                }
                else if((last_char == 'n') or (last_char == 's') or (last_char == 'g')){
                    stringBuilder.deleteCharAt(input_display.text.length-1)
                    stringBuilder.deleteCharAt(input_display.text.length-2)
                    stringBuilder.deleteCharAt(input_display.text.length-3)

                    if (bracket_check == 0) {
                        edited_expression = stringBuilder.toString()
                        if (stringBuilder.toString().isNotEmpty()) calculate(edited_expression)
                    }
                }
                else if((last_char == 't')){
                    stringBuilder.deleteCharAt(input_display.text.length-1)
                    stringBuilder.deleteCharAt(input_display.text.length-2)
                    stringBuilder.deleteCharAt(input_display.text.length-3)
                    stringBuilder.deleteCharAt(input_display.text.length-4)

                    if (bracket_check == 0) {
                        edited_expression = stringBuilder.toString()
                        if (stringBuilder.toString().isNotEmpty()) calculate(edited_expression)
                    }
                }
                else{
                    stringBuilder.deleteCharAt(input_display.text.length-1)
                    operator_check += 1
                }
                if(stringBuilder.isEmpty()) result_display.text = null
                edited_expression = stringBuilder.toString()
                input_display.setText(edited_expression)
            }

            else{
                result_display.text = null
            }
        }
    }

    private fun resetCursorPosition() {
        val position: Int = input_display.length()
        val text: Editable = input_display.text
        Selection.setSelection(text, position)
    }

    private fun showToast(text: String){
        Toast.makeText(this@MainActivity,text, Toast.LENGTH_SHORT).show()
    }

    private fun calculate(expression: String) {

        try{
            if (input_display.text.isNotEmpty()) {
                val result = ExpressionBuilder(expression).build().evaluate()
                val long_result = result.toLong()
                if(operator_check == 0){
                    result_display.text = null
                }
                else{
                    if(result == long_result.toDouble()) result_display.text = Math.round(result.toDouble()).toString()
                    else result_display.setText(result.toString())
                }
            }
        }
        catch (e:ArithmeticException){
            result_display.text = null
            showToast("Invalid Format: Cannot divide by 0")
        }
        catch (e: IllegalArgumentException){
            result_display.text = null
            showToast("Invalid Format")
        }
        catch (e: EmptyStackException){
            result_display.text = null
        }
    }
}