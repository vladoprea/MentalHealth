package com.hfad.mentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.hfad.mentalhealth.databinding.FragmentAnxietyTestBinding

class StressTest : Fragment() {

    private lateinit var binding: FragmentAnxietyTestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /* Inflate the layout for this fragment */
        binding = FragmentAnxietyTestBinding.inflate(inflater, container, false)
        val view = binding.root

        val startTestButton = binding.startTest
        startTestButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_stressTest_to_stressQuestions)
        }

        return view
    }
}