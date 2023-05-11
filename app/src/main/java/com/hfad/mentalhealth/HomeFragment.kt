package com.hfad.mentalhealth

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

class HomeFragment : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_home, container, false)
        val meditateButton = view.findViewById<Button>(R.id.meditation)

        meditateButton.setOnClickListener() {
           view.findNavController().
                   navigate(R.id.action_homeFragment_to_meditateFragment)
        }

        val moodButton =view.findViewById<Button>(R.id.moodentry)

        moodButton.setOnClickListener(){
            view.findNavController().
            navigate(R.id.action_homeFragment_to_moodFragment)
        }

        val journalButton =view.findViewById<Button>(R.id.journalentry)

        journalButton.setOnClickListener(){
            view.findNavController().
            navigate(R.id.action_homeFragment_to_journalFragment)
        }

        val doctorButton =view.findViewById<Button>(R.id.connectdoctor)
        doctorButton.setOnClickListener(){
            view.findNavController().
            navigate(R.id.action_homeFragment_to_doctorFragment)
        }
        return view
    }
}