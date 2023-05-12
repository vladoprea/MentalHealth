package com.hfad.mentalhealth

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class AnxietyTest : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_anxiety_test, container, false)

        val startTest = view.findViewById<Button>(R.id.start_test)
        startTest.setOnClickListener() {
            view.findNavController().navigate(R.id.action_anxietyTest_to_anxietyQuestions)
        }

        return view
    }
}