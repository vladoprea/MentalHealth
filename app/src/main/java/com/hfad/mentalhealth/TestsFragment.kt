package com.hfad.mentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class TestsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tests, container, false)

        val depressionCard = view.findViewById<CardView>(R.id.depression_card_test)
        depressionCard.setOnClickListener() {
            view.findNavController().navigate(R.id.action_testsFragment_to_depressionTest)
        }

        val anxietyCard = view.findViewById<CardView>(R.id.anxiety_card_test)
        anxietyCard.setOnClickListener() {
            view.findNavController().navigate(R.id.action_testsFragment_to_anxietyTest)
        }

        val stressCard = view.findViewById<CardView>(R.id.stress_card_test)
        stressCard.setOnClickListener() {
            view.findNavController().navigate(R.id.action_testsFragment_to_stressTest)
        }

        return view
    }

}

