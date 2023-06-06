package com.hfad.mentalhealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(private var doctorList: List<DoctorList>) :
    RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_of_doctors, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = doctorList[position]
            holder.nameView.text = item.name
            holder.specializationView.text = item.specialization
            holder.experienceView.text = item.experience
            holder.priceView.text = item.price
            holder.faceDoctorView.setImageResource(item.face_doctor)
            holder.expIconView.setImageResource(item.exp_icon)
            holder.priceIconView.setImageResource(item.price_icon)


        holder.itemView.setOnClickListener {
            val action = ConnectFragmentDirections.actionConnectFragmentToDoctorDescription(
                item.face_doctor,
                item.name,
                item.description
            )
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    fun updateData(newList: List<DoctorList>) {
        doctorList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = itemView.findViewById(R.id.doctor_name)
        val specializationView: TextView = itemView.findViewById(R.id.doctor_specialization)
        val experienceView: TextView = itemView.findViewById(R.id.doctor_experience)
        val priceView: TextView = itemView.findViewById(R.id.doctor_price)
        val faceDoctorView: ImageView = itemView.findViewById(R.id.doctor_face)
        val expIconView: ImageView = itemView.findViewById(R.id.doctor_exp_icon)
        val priceIconView: ImageView = itemView.findViewById(R.id.doctor_price_icon)

    }
}
