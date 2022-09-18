package com.example.homework1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.homework1.databinding.Fragment1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_COUNTER = "counter"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {

    private var counter: Int = 0
    private var color: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn1: Button = view.findViewById(R.id.button)
        val btn2: Button = view.findViewById(R.id.button2)
        val btn3: Button = view.findViewById(R.id.button3)

        val fragment2 = Fragment2()
        val bundle = Bundle()
        fragment2.arguments = bundle


        btn1.setOnClickListener{
            var ft: FragmentTransaction? = fragmentManager?.beginTransaction()
            ft?.replace(R.id.fragmentContainerView, fragment2)?.addToBackStack(null)
            ft?.commit()
        }
        btn2.setOnClickListener{
            counter += 1
            bundle.putInt("data", counter)
        }
        btn3.setOnClickListener{
            color += 1
            bundle.putInt("colordata", color)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

//    companion object {
//        fun newInstance() =
//            Fragment1().apply {
//                arguments = Bundle().apply {
//                    putInt("data", counter)
//
//                }
//            }
//    }
}