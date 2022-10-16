package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPlayerBinding

class PlayerHolder(
    val binding: ItemPlayerBinding,
    private val onItemClick: (Player) -> Unit
) : RecyclerView.ViewHolder(binding.root){

    fun onBind(player: Player) {
        with(binding){
            playerName.text = "#" + player.number + " " +  player.name
            root.setOnClickListener{
                onItemClick(player)

                //InfoFragment()
                //AllPlayers.players[adapterPosition]
            }
        }
    }
}