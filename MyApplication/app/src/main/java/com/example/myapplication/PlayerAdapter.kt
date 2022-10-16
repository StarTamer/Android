package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPlayerBinding

class PlayerAdapter(
    private val list: List<Player>,
    private val onItemClick: (Player) -> Unit,
): RecyclerView.Adapter<PlayerHolder>() {

    val playersList = ArrayList<Player>()
    var ID : Int = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerHolder = PlayerHolder(
        binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onItemClick
    )

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.onBind(playersList[position])
    }

    override fun getItemCount(): Int {
        return playersList.size
    }

}