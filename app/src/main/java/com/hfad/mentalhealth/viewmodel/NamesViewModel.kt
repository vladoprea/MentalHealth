package com.hfad.mentalhealth.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.mentalhealth.DoctorList
import com.hfad.mentalhealth.R
import com.hfad.mentalhealth.model.Names
import com.hfad.mentalhealth.repository.NamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NamesViewModel @Inject constructor(private val repository: NamesRepository): ViewModel() {

    val _names = MutableLiveData<List<Names>>()
    val names: LiveData<List<Names>> = _names

    private val hardcodedList: List<DoctorList> = listOf(
        DoctorList(
            "Ana Maria Golea",
            "Psychotherapy",
            "3 years\n experience",
            "100£ \n fee range",
            R.drawable.anamariagolea,
            R.drawable.clepsidra_icon,
            R.drawable.price_icon,
            "Psychotherapy is a type of treatment that can help individuals experiencing a wide array of mental health conditions and emotional challenges. Psychotherapy can help not only alleviate symptoms, but also, certain types of psychotherapies can help identify the psychological root causes of one’s condition so a person can function better and have enhanced emotional well-being and healing."
        ),
        DoctorList(
            "Laura Tanase",
            "Counseling",
            "4 years\n experience",
            "100£-150£ \n fee range",
            R.drawable.lauratanase,
            R.drawable.clepsidra_icon,
            R.drawable.price_icon,
            "Psychotherapy is a type of treatment that can help individuals experiencing a wide array of mental health conditions and emotional challenges. Psychotherapy can help not only alleviate symptoms, but also, certain types of psychotherapies can help identify the psychological root causes of one’s condition so a person can function better and have enhanced emotional well-being and healing."
        ),
        DoctorList(
            "Lucian Pirvulescu",
            "Psychotherapy",
            "5 years\n experience",
            "150£ \n fee range",
            R.drawable.lucianpirvulescu,
            R.drawable.clepsidra_icon,
            R.drawable.price_icon,
            "Counseling is a collaborative effort between the counselor and client. Professional counselors help clients identify goals and potential solutions to problems which cause emotional turmoil; seek to improve communication and coping skills; strengthen self-esteem; and promote behavior change and optimal mental health."
        ),

        DoctorList(
            "Stefania Stoica",
            "Psychotherapy",
            "3 years\n experience",
            "120£ \n fee range",
            R.drawable.stefaniastoica,
            R.drawable.clepsidra_icon,
            R.drawable.price_icon,
            "Counseling is a collaborative effort between the counselor and client. Professional counselors help clients identify goals and potential solutions to problems which cause emotional turmoil; seek to improve communication and coping skills; strengthen self-esteem; and promote behavior change and optimal mental health."
        ),
        DoctorList(
            "Maria Cornelia",
            "Couple Therapy",
            "6 years\n experience",
            "150£-200£ \n fee range",
            R.drawable.mariacornelia,
            R.drawable.clepsidra_icon,
            R.drawable.price_icon,
            "Psychotherapy is a type of treatment that can help individuals experiencing a wide array of mental health conditions and emotional challenges. Psychotherapy can help not only alleviate symptoms, but also, certain types of psychotherapies can help identify the psychological root causes of one’s condition so a person can function better and have enhanced emotional well-being and healing."
        ),
        DoctorList(
            "Stefan Apopei",
            "Psychotherapy",
            "2 years\n experience",
            "100£ \n fee range",
            R.drawable.stefanapopei,
            R.drawable.clepsidra_icon,
            R.drawable.price_icon,
            "Couple counseling is a type of therapy that helps couples improve their relationship. It can help couples resolve conflict, communicate better, and understand each other’s needs. Couple counseling can be beneficial for both partners in a relationship. It can also help couples who are thinking about getting married or who are already married."
        ),
        DoctorList(
            "Valentin Chezan",
            "Psychotherapy",
            "5 years\n experience",
            "150£-200£ \n fee range",
            R.drawable.valentinchezan,
            R.drawable.clepsidra_icon,
            R.drawable.price_icon,
            "Counseling is a collaborative effort between the counselor and client. Professional counselors help clients identify goals and potential solutions to problems which cause emotional turmoil; seek to improve communication and coping skills; strengthen self-esteem; and promote behavior change and optimal mental health."
        ),
    )

    init {
        _names.value = emptyList()
    }

    @SuppressLint("SuspiciousIndentation")
    fun getAllNames() {
        viewModelScope.launch {
            val response = repository.getNames()
            if (response.isSuccessful) {
                _names.value = response.body()
            } else {
                Log.e("NamesViewModel", "error")
            }
        }
    }

    private fun convertToDoctorList(names:Names): DoctorList {
        return DoctorList(
            name = "${names.first_name} ${names.last_name}",
            specialization = "",
            experience = "",
            price = "",
            face_doctor = R.drawable.stefanapopei,
            exp_icon = R.drawable.clepsidra_icon,
            price_icon = R.drawable.price_icon,
            description = ""
        )
    }

    fun getDoctorList(): List<DoctorList> {
        val apiData = names.value ?: emptyList()
        val convertedData = apiData.map {convertToDoctorList(it)}
        return hardcodedList + convertedData
    }
}