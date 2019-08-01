package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Kevin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }



        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }
    }

       fun addNickname(view: View) {

           binding.apply{
               myName?.nickname = nicknameEdit.text.toString()
               NicknameText2.text = binding.nicknameEdit.text
               invalidateAll()
               binding.nicknameEdit.visibility = View.GONE
               binding.doneButton.visibility = View.GONE
               binding.NicknameText2.visibility = View.GONE
           }

        val editText = findViewById<TextView>(R.id.Nickname_text2)
        val nicknameTextView = findViewById<TextView>(R.id.Nickname_text2)

        nicknameTextView.text  = editText.text.toString()
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
