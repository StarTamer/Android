package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val infoFragment = InfoFragment()

    private val adapter = PlayerAdapter(AllPlayers.players) {
        val ft: FragmentTransaction? = fragmentManager?.beginTransaction()
        ft?.replace(R.id.fragmentContainerView, infoFragment)?.addToBackStack(null)
        ft?.commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentListBinding.inflate(layoutInflater)
        init()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    private fun init(){
        binding.apply{
            RCVplayers.layoutManager = LinearLayoutManager(context)
            RCVplayers.adapter = adapter
            adapter.playersList.addAll(AllPlayers.players)

        }
    }

}