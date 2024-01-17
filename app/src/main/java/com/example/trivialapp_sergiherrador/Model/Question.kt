package com.example.trivialapp_sergiherrador.Model

import com.example.trivialapp_sergiherrador.R

// Aquí van las dataclases y eso

data class Question(
    val questionName: String,
    val questionText: String,
    val questionImage: Int,
    val difficulty: Difficulty,
    val answers: List<Answer>
) {
    data class Answer(
        val answerText: String,
        val isCorrect: Boolean
    )

    enum class Difficulty {
        EASY,
        MEDIUM,
        HARD
    }
}

val easyQuestions = listOf(
    Question(
        "Easy 1",
        "¿Como se llama este personaje de sanrio?",
        R.drawable.kuromitrivia,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Keroppi", false),
            Question.Answer("Kuromi", true),
            Question.Answer("Manolo", false),
            Question.Answer("MyMelody", false)
        )
    ),
    Question(
        "Easy 2",
        "¿Que animal representa este dibujo?",
        R.drawable.ajolote,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Ajolote", true),
            Question.Answer("Yo", false),
            Question.Answer("Dani Santiago", false),
            Question.Answer("Marsupilami", false)
        )
    )

)

val mediumQuestions = listOf(
    Question(
        "Medium 1",
        "¿A que campeón del lol pertenece esta habilidad?",
        R.drawable.sennacurse,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Janna", false),
            Question.Answer("Zyra", false),
            Question.Answer("Senna", true),
            Question.Answer("Gragas", false)
        )
    ),
    Question(
        "Medium 2",
        "¿A que obra pertenece el grupo SEX-BOB-OMB?",
        R.drawable.sexbobomb,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Acero Puro", false),
            Question.Answer("Titanic", false),
            Question.Answer("Scott Pilgrim vs the World", true),
            Question.Answer("Twisted Metals", false)
        )
    )
)

val hardQuestions = listOf(
    Question(
        "Hard 1",
        "¿A que juego pertenece este personaje?",
        R.drawable.neonagent,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Oro", true),
            Question.Answer("Plata", false),
            Question.Answer("Platino", false),
            Question.Answer("Mercurio", false)
        )
    ),
    Question(
        "Hard 2",
        "¿Cómo se llama el hermano de Kratos?",
        R.drawable.godofwar,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Heracles", false),
            Question.Answer("Corinto", false),
            Question.Answer("Deimos", true),
            Question.Answer("Sefisto", false)
        )
    )
    // Agrega más preguntas difíciles según sea necesario
)
