package com.example.task2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var clickCount = 0
    data class Person(var name: String , var count: Int)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView = findViewById<TextView>(R.id.textRezult)
        val ClickMeButton = findViewById<TextView>(R.id.clickButton)
        val userNameTextInput = findViewById<TextInputLayout>(R.id.nameText)
        val people: MutableList<Person> = mutableListOf()

        ClickMeButton.setOnClickListener{
            val userName = userNameTextInput.editText?.text?.toString()
            val maskUserName =
                if(userName.isNullOrEmpty()) "Sombody"
                else userName
            if (people.none { it.name == maskUserName }) {
                val user = Person(maskUserName, 1)
                people.add(user)
                clickCountDisplayView.text = "${user.name} clicked ${user.count} times"
            }
            else {
                val user = people.filter { it.name == maskUserName }
                user[0].count++
                clickCountDisplayView.text = "${user[0].name} clicked ${user[0].count} times"
            }
        }
    }
}