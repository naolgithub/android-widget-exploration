package com.example.widgetexploration

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
//import android.widget.CompoundButton
//import android.widget.RadioButton
//import kotlinx.android.synthetic.main.exploration_layout.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(R.layout.exploration_layout)

        // Listen for clicks on the button,
        // the CheckBoxes and the RadioButtons
        // setOnCheckedChangeListener requires an interface of type
        // CompoundButton.OnCheckedChangeListener. In turn this interface
        // has a function called onCheckedChanged
        // It is all handled by the lambda
        val checkBoxTransparency=findViewById<CheckBox>(R.id.checkBoxTransparency)
        val imageView=findViewById<ImageView>(R.id.imageView)
        checkBoxTransparency.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                //Set some transparency
                imageView.alpha = .1f
            } else {
                // Remove the transparency
                imageView.alpha = 1f
            }
        }
        val checkBoxTint=findViewById<CheckBox>(R.id.checkBoxTint)
        checkBoxTint.setOnCheckedChangeListener{
                _, isChecked ->
            if (isChecked) {
                // Checked so set some tint
                imageView.setColorFilter(Color.argb(150, 255, 0, 0))
            } else {
                // No tint required
                imageView.setColorFilter(Color.argb(0, 0, 0, 0))
            }
        }
        val checkBoxReSize=findViewById<CheckBox>(R.id.checkBoxReSize)
        checkBoxReSize.setOnCheckedChangeListener{
                _, isChecked ->
            if (isChecked) {
                // It's checked so make bigger
                imageView.scaleX = 2f
                imageView.scaleY = 2f
            } else {
                // It's not checked make regular size
                imageView.scaleX = 1f
                imageView.scaleY = 1f
            } }
        val radioGroup=findViewById<RadioGroup>(R.id.radioGroup)
        val textClock=findViewById<TextClock>(R.id.textClock)
        // Now for the radio buttons
        // Uncheck all buttons
        radioGroup.clearCheck()
        radioGroup.setOnCheckedChangeListener{
            group,checkedId ->
            val rb=group.findViewById<View>(checkedId) as RadioButton
            when(rb.id){
                R.id.radioButtonLondon ->
                    textClock.timeZone = "Europe/London"
                R.id.radioButtonBeijing ->
                    textClock.timeZone = "CST6CDT"
                R.id.radioButtonNewYork ->
                    textClock.timeZone = "America/New_York"
                R.id.radioButtonEuropeanEmpire ->
                    textClock.timeZone = "Europe/Brussels"
            }
        }
        /*
      Let's listen for clicks on our "Capture" Button.
      The compiler has worked out that the single function
      of the required interface has a single parameter.
      Therefore, the syntax is shortened (->) is removed
      and the only parameter, (should we have needed it)
      is declared invisibly as "it"
   */
        val textView=findViewById<TextView>(R.id.textView)
        val editText=findViewById<EditText>(R.id.editText)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // it... accesses the view that was clicked
            // We want to act on the textView and editText instances
            // Change the text on the TextView
            // to whatever is currently in the EditText
            textView.text = editText.text
        }
        val switch1=findViewById<Switch>(R.id.switch1)
        // Show or hide the TextView
        switch1.setOnCheckedChangeListener {
                _, isChecked ->
            if (isChecked) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.INVISIBLE
            }
        }
    }
}