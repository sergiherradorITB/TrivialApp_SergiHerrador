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
    ),
    Question(
        "Easy 3",
        "¿Cuál es el nombre de este personaje de anime?",
        R.drawable.naruto,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Luffy", false),
            Question.Answer("Naruto", true),
            Question.Answer("Goku", false),
            Question.Answer("Sasuke", false)
        )
    ),
    Question(
        "Easy 4",
        "¿Qué tipo de criatura es esta en la serie 'Pokémon'?",
        R.drawable.pikachu,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Gato", false),
            Question.Answer("Pikachu", true),
            Question.Answer("Dragón", false),
            Question.Answer("Rana", false)
        )
    ),
    Question(
        "Easy 5",
        "¿En qué anime se encuentra el personaje 'Monkey D. Luffy'?",
        R.drawable.luffy,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("One Piece", true),
            Question.Answer("Naruto", false),
            Question.Answer("Dragon Ball", false),
            Question.Answer("Bleach", false)
        )
    ),
    Question(
        "Easy 6",
        "¿Cómo se llama el estudio de animación que creó 'Mi Vecino Totoro'?",
        R.drawable.totoro,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Ghibli", true),
            Question.Answer("Toei Animation", false),
            Question.Answer("Madhouse", false),
            Question.Answer("Sunrise", false)
        )
    ),
    Question(
        "Easy 7",
        "¿Cuál es el nombre del protagonista en 'Dragon Ball Z'?",
        R.drawable.goku,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Vegeta", false),
            Question.Answer("Gohan", false),
            Question.Answer("Goku", true),
            Question.Answer("Piccolo", false)
        )
    ),
    Question(
        "Easy 8",
        "¿Cuál es el nombre de este Pokémon de tipo agua?",
        R.drawable.squirtle,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Charmander", false),
            Question.Answer("Bulbasaur", false),
            Question.Answer("Squirtle", true),
            Question.Answer("Pikachu", false)
        )
    ),
    Question(
        "Easy 9",
        "¿En qué serie de anime los personajes luchan contra titanes?",
        R.drawable.attack_on_titan,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("One Punch Man", false),
            Question.Answer("Naruto", false),
            Question.Answer("Attack on Titan", true),
            Question.Answer("Bleach", false)
        )
    ),
    Question(
        "Easy 10",
        "¿Cuál es el nombre de la protagonista en 'Sailor Moon'?",
        R.drawable.sailor_moon,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Usagi Tsukino", true),
            Question.Answer("Rei Hino", false),
            Question.Answer("Ami Mizuno", false),
            Question.Answer("Makoto Kino", false)
        )
    ),
    Question(
        "Easy 11",
        "¿Cuál es el nombre de este Pokémon de tipo fuego?",
        R.drawable.charmander,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Bulbasaur", false),
            Question.Answer("Squirtle", false),
            Question.Answer("Charmander", true),
            Question.Answer("Pikachu", false)
        )
    ),
    Question(
        "Easy 12",
        "¿Cuál es el nombre del protagonista en 'My Hero Academia'?",
        R.drawable.deku,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Bakugo", false),
            Question.Answer("All Might", false),
            Question.Answer("Deku", true),
            Question.Answer("Todoroki", false)
        )
    ),
    Question(
        "Easy 13",
        "¿En qué serie de anime los personajes cazan monstruos llamados 'Youkai'?",
        R.drawable.yokai_watch,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Digimon", false),
            Question.Answer("Yokai Watch", true),
            Question.Answer("Pokémon", false),
            Question.Answer("Beyblade", false)
        )
    ),
    Question(
        "Easy 14",
        "¿Cuál es el nombre del hermano menor de Edward Elric en 'Fullmetal Alchemist'?",
        R.drawable.alphonse,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Roy", false),
            Question.Answer("Alphonse", true),
            Question.Answer("Greed", false),
            Question.Answer("Envy", false)
        )
    ),
    Question(
        "Easy 15",
        "¿Cómo se llama el director de Studio Ghibli?",
        R.drawable.miyazaki,
        Question.Difficulty.EASY,
        listOf(
            Question.Answer("Isao Takahata", false),
            Question.Answer("Mamoru Hosoda", false),
            Question.Answer("Hayao Miyazaki", true),
            Question.Answer("Satoshi Kon", false)
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
