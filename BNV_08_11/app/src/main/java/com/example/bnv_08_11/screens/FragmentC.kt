package com.example.bnv_08_11.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bnv_08_11.R

class FragmentC: Fragment(R.layout.fragment_c) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById<Button>(R.id.buttonС1)

        button.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentC_to_fragmentС2)
        }
    }
}