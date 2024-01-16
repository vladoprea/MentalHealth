package com.hfad.mentalhealth

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class AnxietyQuestions : Fragment() {

    private var currentQuestionIndex = 0
    private lateinit var questionTextView: TextView
    private lateinit var choiceRadioGroup: RadioGroup
    private val questions = listOf(
        QuestionsAnswersList(
            "Feeling nervous, anxious or on edge?",
            listOf("Not at all", "Several days", "More than half the days", "Nearly every day")
        ),
        QuestionsAnswersList(
            "Not being able to stop or control worrying?",
            listOf("Not at all", "Several days", "More than half the days", "Nearly every day")
        ),
        QuestionsAnswersList(
            "Being so restless that it is hard to sit still?",
            listOf("Not at all", "Several days", "More than half the days", "Nearly every day")
        )
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_anxiety_questions, container, false)

        questionTextView = view.findViewById(R.id.question_anxiety)
        choiceRadioGroup = view.findViewById(R.id.anxiety_radio_group)
        val nextButton = view.findViewById<Button>(R.id.next_button)


        Singleton.clearAnswers()
        showQuestion()

        nextButton.setOnClickListener {
           handleNextButtonClick(view)
        }
        // Set up radio group change listener
        choiceRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            nextButton.isEnabled = checkedId != -1
        }

        //Disable Next Button initially
        nextButton.isEnabled = false

        return view
    }

    private fun handleNextButtonClick(view:View) {
        // Save answer to the question
        val selectedAnswer = choiceRadioGroup.checkedRadioButtonId
        if (selectedAnswer != -1) {
            val answerIndex = choiceRadioGroup.indexOfChild(view.findViewById(selectedAnswer))
            Singleton.answers[currentQuestionIndex] = answerIndex
        }
        // Move to the next question
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            showQuestion()
        } else {
           showTestEnd(view)
        }
    }

    private fun showTestEnd(view: View) {

        val testEnd = view.findViewById<TextView>(R.id.test_end)
        val nextButton = view.findViewById<Button>(R.id.next_button)

        testEnd.visibility = View.VISIBLE
        questionTextView.visibility = View.GONE
        choiceRadioGroup.visibility = View.GONE
        nextButton.visibility = View.GONE
    }

    private fun showQuestion() {
        val question = questions[currentQuestionIndex]

        questionTextView.text = question.questions_text

        choiceRadioGroup.removeAllViews()

        choiceRadioGroup.clearCheck()

        for (i in question.answersAll.indices) {
            val radioButton = RadioButton(requireContext())
            radioButton.text = question.answersAll[i]
            choiceRadioGroup.addView(radioButton)

            if (Singleton.answers.containsKey(currentQuestionIndex) && Singleton.answers[currentQuestionIndex] == i) {
                radioButton.isChecked = true
            }
        }
    }
}