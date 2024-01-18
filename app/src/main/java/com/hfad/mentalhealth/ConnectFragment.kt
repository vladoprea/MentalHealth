package com.hfad.mentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.mentalhealth.viewmodel.NamesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConnectFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DoctorAdapter
    private lateinit var namesViewModel: NamesViewModel

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connect, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = DoctorAdapter(emptyList())
        recyclerView.adapter = adapter

        namesViewModel = ViewModelProvider(this).get(NamesViewModel::class.java)
        namesViewModel.names.observe(viewLifecycleOwner) { _ ->
            val doctorList = namesViewModel.getDoctorList()
            adapter.updateData(doctorList)
        }

        namesViewModel.getAllNames()
    }
}