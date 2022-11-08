package com.example.bnv_08_11.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.bnv_08_11.R

class FragmentA: Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById<Button>(R.id.buttonA1)

        button.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentA_to_fragmentA2)
        }
    }
}