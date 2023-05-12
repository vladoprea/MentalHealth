package com.hfad.mentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.findNavController

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val accountLayout = view.findViewById<LinearLayout>(R.id.your_account)

        accountLayout.setOnClickListener() {
            view.findNavController().navigate(R.id.action_settingsFragment_to_accountFragment)
        }

        val securityLayout = view.findViewById<LinearLayout>(R.id.security)

        securityLayout.setOnClickListener() {
            view.findNavController().navigate(R.id.action_settingsFragment_to_securityFragment)
        }

        val customizationLayout = view.findViewById<LinearLayout>(R.id.customization)

        customizationLayout.setOnClickListener() {
            view.findNavController().navigate(R.id.action_settingsFragment_to_customizationFragment)
        }

        val notificationsLayout = view.findViewById<LinearLayout>(R.id.notifications)

        notificationsLayout.setOnClickListener() {
            view.findNavController().navigate(R.id.action_settingsFragment_to_notificationsFragment)
        }

        val accessibilityLayout = view.findViewById<LinearLayout>(R.id.accessibility)

        accessibilityLayout.setOnClickListener() {
            view.findNavController().navigate(R.id.action_settingsFragment_to_accessibilityFragment)
        }
        return view
    }
}