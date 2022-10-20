package com.example.praktikum2.day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praktikum2.R
import com.example.praktikum2.databinding.ActivityDay3Binding
import com.example.praktikum2.day3.adapter.ListHeroAdapter
import com.example.praktikum2.day3.model.Hero

class Day3Activity : AppCompatActivity() {

    private lateinit var binding : ActivityDay3Binding

    private val adapter: ListHeroAdapter by lazy { ListHeroAdapter() }

    private val listHeroes: ArrayList<Hero>
    get(){
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices){
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDay3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecyclerView()
    }

    private fun showRecyclerView() {
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        binding.rvHeroes.adapter = adapter
        adapter.submitList(listHeroes)
        adapter.listener = object : ListHeroAdapter.ItemListener {
            override fun onClick(data: Hero) {
                Toast.makeText(this@Day3Activity, data.name, Toast.LENGTH_SHORT).show()
            }

        }
    }
}