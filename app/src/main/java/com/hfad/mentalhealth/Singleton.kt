package com.hfad.mentalhealth

object Singleton {
    var answers = mutableMapOf<Int, Int>()

    fun clearAnswers() {
        answers.clear()
    }
}