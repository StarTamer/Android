package com.example.bnv_08_11.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bnv_08_11.R

class FragmentB: Fragment(R.layout.fragment_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val edit_text = view.findViewById<EditText>(R.id.edit_text).text
            findNavController().navigate(
                R.id.action_fragmentB_to_fragmentB2,
                bundleOf(FragmentB2.text to "$edit_text"))
        }
    }
}