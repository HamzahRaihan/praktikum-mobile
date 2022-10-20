package com.example.praktikum2.day2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.praktikum2.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle()
        bundle.putString(EXTRA_TEXT, "Ini teks dari main fragment")

        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle

        val button: Button = view.findViewById(R.id.btn_move_to_second_fragment)
        button.setOnClickListener {
            val fragmentManager = parentFragmentManager.beginTransaction()
            fragmentManager.replace(R.id.container, secondFragment)
            fragmentManager.addToBackStack(null)
            fragmentManager.commit()
        }
    }

    companion object {
        const val EXTRA_TEXT = "extra_text"
    }
}