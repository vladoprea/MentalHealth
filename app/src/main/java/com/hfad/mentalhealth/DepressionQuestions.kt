package com.hfad.mentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class DepressionQuestions : Fragment() {

    private var currentQuestionIndex = 0
    private lateinit var questionTextView: TextView
    private lateinit var choiceRadioGroup: RadioGroup
    private val questions = listOf(
        QuestionsAnswersList(
            "Little interest or pleasure in doing things?",
            listOf("Several days", "Not at all", "More than half the days", "Nearly every day")
        ),
        QuestionsAnswersList(
            "Feeling down, depressed, or hopeless?",
            listOf("Several days", "Not at all", "More than half the days", "Nearly every day")
        ),
        QuestionsAnswersList(
            "Trouble falling or staying asleep, or sleeping too much?",
            listOf("Several days", "Not at all", "More than half the days", "Nearly every day")
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_depression_questions, container, false)

        questionTextView = view.findViewById(R.id.question_depression)
        choiceRadioGroup = view.findViewById(R.id.depression_radio_group)
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