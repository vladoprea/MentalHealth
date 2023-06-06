package com.hfad.mentalhealth

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorDescription : Fragment() {
    private val args: DoctorDescriptionArgs by navArgs()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_doctor_description, container, false)


        val imageView = view.findViewById<ImageView>(R.id.doctor_face)
        val nameView = view.findViewById<TextView>(R.id.doctor_name)
        val descriptionView = view.findViewById<TextView>(R.id.doctor_description)


        val imageResId = args.image
        val namedoctor = args.name
        val descriptiondoctor = args.description

        imageView.setImageResource(imageResId)
        nameView.text = namedoctor
        descriptionView.text = descriptiondoctor

        return view
    }
}