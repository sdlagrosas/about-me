package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName:MyName = MyName( "Tim Hortons")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{ addNickname() }
        binding.nicknameText.setOnClickListener { updateNickname() }
    }

    private fun addNickname() {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()

            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE

            binding.nicknameText.visibility = View.VISIBLE
        }
        // hide button
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)


    }

    private fun updateNickname () {
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        binding.nicknameText.visibility = View.GONE

        // Set focus to the edit text
        binding.nicknameEdit.requestFocus()

        // Show keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)



    }

}
