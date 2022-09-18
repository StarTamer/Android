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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_COUNTER = "counter"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var counter: Int? = null
    private var param1: String? = null
    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            counter = it.getInt("ARG_COUNTER")
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//
//    }

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

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        var counter = arguments?.getInt("ARG_COUNTER")
//        val tv: TextView? = activity?.findViewById(R.id.text)
//        tv?.text = counter.toString()
//    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}