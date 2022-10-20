package com.example.praktikum2.day3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praktikum2.databinding.ItemRowHeroBinding
import com.example.praktikum2.day3.model.Hero

class ListHeroAdapter : RecyclerView.Adapter<ListHeroAdapter.ListHeroViewHolder>(){

    private val heroes = mutableListOf<Hero>()
    var listener: ItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHeroViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ListHeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListHeroViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    fun submitList(list: List<Hero> ){
        heroes.clear()
        heroes.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = heroes.size

    inner class ListHeroViewHolder(private val binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(data: Hero){
            binding.tvItemName.text = data.name
            binding.tvItemDescription.text = data.description
//            binding.imgItemPhoto.setImageResource(data.photo)
            Glide.with(itemView.context)
                .load(data.photo)
                .into(binding.imgItemPhoto)
            itemView.setOnClickListener { listener?.onClick(data) }
        }
    }

    interface ItemListener {
        fun onClick(data: Hero)
    }
}