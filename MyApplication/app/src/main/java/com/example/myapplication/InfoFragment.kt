package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class InfoFragment : Fragment() {

    private var playerID : Int = 0
    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //playerID = arguments?.getInt("ID")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_info, container, false)

        //textView.text = "fadfs"
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.textView)
        textView.text = "${AllPlayers.players[playerID].name} \n " +
                "number: ${AllPlayers.players[playerID].number} \n " +
                "position: ${AllPlayers.players[playerID].position} \n " +
                "country: ${AllPlayers.players[playerID].country} \n " +
                "age: ${AllPlayers.players[playerID].age} \n " +
                "height: ${AllPlayers.players[playerID].height} \n " +
                "weight: ${AllPlayers.players[playerID].weight} \n "
    }
}