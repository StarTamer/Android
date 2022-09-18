package com.example.homework1

import android.content.Context
import android.graphics.Color
import android.graphics.Color.red
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class Fragment2 : Fragment() {

    private var counter: Int? = null

    fun getColor(id: Int): Int {
        var color: Int = android.graphics.Color.RED
        when (id%6) {
            0 -> color = R.color.purple_700
            1 -> color = R.color.black
            2 -> color = R.color.purple_200
            3 -> color = R.color.purple_500
            4 -> color = R.color.teal_200
            5 -> color = R.color.teal_700
        }
        return color
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val textView: TextView = view.findViewById(R.id.textv)
        val imageView: ImageView = view.findViewById(R.id.image)
        val args = this.arguments
        val inputData = args?.getInt("data")
        val color = args?.getInt("colordata")

        textView.text = if (inputData!=0) inputData.toString() else ""
        imageView.setColorFilter(ContextCompat.getColor(requireContext(), getColor(color!!)))

        return view
    }

}