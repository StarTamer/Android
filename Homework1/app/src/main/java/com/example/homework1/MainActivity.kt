package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework1.databinding.Fragment1Binding

class MainActivity : AppCompatActivity() {

    lateinit var binding: Fragment1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = Fragment1Binding.inflate(layoutInflater)

//        binding.button.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragmentContainerView, Fragment2.newInstance())
//                .commit()
//        }
    }

}