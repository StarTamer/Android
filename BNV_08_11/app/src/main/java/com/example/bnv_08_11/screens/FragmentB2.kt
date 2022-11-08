package com.example.bnv_08_11.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bnv_08_11.R

class FragmentB2: Fragment(R.layout.fragment_b2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView2).text = arguments?.getString(text)
    }

    companion object {
        const val text = "EDIT_TEXT"
    }
}