package com.hfad.mentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ConnectFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var dataList = listOf<DoctorList>()
    private lateinit var adapter: DoctorAdapter




    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_connect, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataList = listOf(
            DoctorList("Ana Maria Golea", "Psychotherapy", "3 years\n experience","100£ \n fee range", R.drawable.anamariagolea, R.drawable.clepsidra_icon, R.drawable.price_icon,"Psychotherapy is a type of treatment that can help individuals experiencing a wide array of mental health conditions and emotional challenges. Psychotherapy can help not only alleviate symptoms, but also, certain types of psychotherapies can help identify the psychological root causes of one’s condition so a person can function better and have enhanced emotional well-being and healing."),
            DoctorList("Laura Tanase", "Counseling", "4 years\n experience","100£-150£ \n fee range", R.drawable.lauratanase, R.drawable.clepsidra_icon, R.drawable.price_icon, "Psychotherapy is a type of treatment that can help individuals experiencing a wide array of mental health conditions and emotional challenges. Psychotherapy can help not only alleviate symptoms, but also, certain types of psychotherapies can help identify the psychological root causes of one’s condition so a person can function better and have enhanced emotional well-being and healing."),
            DoctorList("Lucian Pirvulescu", "Psychotherapy", "5 years\n experience","150£ \n fee range", R.drawable.lucianpirvulescu, R.drawable.clepsidra_icon, R.drawable.price_icon, "Counseling is a collaborative effort between the counselor and client. Professional counselors help clients identify goals and potential solutions to problems which cause emotional turmoil; seek to improve communication and coping skills; strengthen self-esteem; and promote behavior change and optimal mental health."),
            DoctorList("Maria Cornelia", "Couple Therapy", "6 years\n experience","150£-200£ \n fee range", R.drawable.stefanapopei, R.drawable.clepsidra_icon, R.drawable.price_icon, "Psychotherapy is a type of treatment that can help individuals experiencing a wide array of mental health conditions and emotional challenges. Psychotherapy can help not only alleviate symptoms, but also, certain types of psychotherapies can help identify the psychological root causes of one’s condition so a person can function better and have enhanced emotional well-being and healing."),
            DoctorList("Stefania Stoica", "Psychotherapy", "3 years\n experience","120£ \n fee range", R.drawable.stefaniastoica, R.drawable.clepsidra_icon, R.drawable.price_icon, "Counseling is a collaborative effort between the counselor and client. Professional counselors help clients identify goals and potential solutions to problems which cause emotional turmoil; seek to improve communication and coping skills; strengthen self-esteem; and promote behavior change and optimal mental health."),
            DoctorList("Maria Cornelia", "Couple Therapy", "6 years\n experience","150£-200£ \n fee range", R.drawable.stefanapopei, R.drawable.clepsidra_icon, R.drawable.price_icon, "Psychotherapy is a type of treatment that can help individuals experiencing a wide array of mental health conditions and emotional challenges. Psychotherapy can help not only alleviate symptoms, but also, certain types of psychotherapies can help identify the psychological root causes of one’s condition so a person can function better and have enhanced emotional well-being and healing."),
            DoctorList("Stefan Apopei", "Psychotherapy", "2 years\n experience","100£ \n fee range", R.drawable.stefanapopei, R.drawable.clepsidra_icon, R.drawable.price_icon, "Couple counseling is a type of therapy that helps couples improve their relationship. It can help couples resolve conflict, communicate better, and understand each other’s needs. Couple counseling can be beneficial for both partners in a relationship. It can also help couples who are thinking about getting married or who are already married."),
            DoctorList("Valentin Chezan", "Psychotherapy", "5 years\n experience","150£-200£ \n fee range", R.drawable.valentinchezan, R.drawable.clepsidra_icon, R.drawable.price_icon, "Counseling is a collaborative effort between the counselor and client. Professional counselors help clients identify goals and potential solutions to problems which cause emotional turmoil; seek to improve communication and coping skills; strengthen self-esteem; and promote behavior change and optimal mental health."),
            DoctorList("Maria Cornelia", "Couple Therapy", "6 years\n experience","150£-200£ \n fee range", R.drawable.stefanapopei, R.drawable.clepsidra_icon, R.drawable.price_icon, "Psychotherapy is a type of treatment that can help individuals experiencing a wide array of mental health conditions and emotional challenges. Psychotherapy can help not only alleviate symptoms, but also, certain types of psychotherapies can help identify the psychological root causes of one’s condition so a person can function better and have enhanced emotional well-being and healing."),
        )


        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = DoctorAdapter(dataList)
        recyclerView.adapter = adapter


    }

}