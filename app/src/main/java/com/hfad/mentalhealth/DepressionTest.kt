package com.hfad.mentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class DepressionTest : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_depression_test, container, false)

        val startTest = view.findViewById<Button>(R.id.start_test)
        startTest.setOnClickListener() {
            view.findNavController().
            navigate(R.id.action_depressionTest_to_depressionQuestions)
        }

        return view
    }
}