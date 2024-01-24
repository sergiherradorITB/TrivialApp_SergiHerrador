package com.example.trivialapp_sergiherrador.Model

import com.example.trivialapp_sergiherrador.R

// Aquí van las dataclases y eso

data class Question(
    val questionName: String,
    val questionText: String,
    val questionImage: Int,
    val difficulty: Difficulty,
    val answers: List<Answer>,
    var respondida: Boolean
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
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
        ),
        false
    )

)

val mediumQuestions = listOf(
    Question(
        "Medium 1",
        "¿Cuál es el nombre del campeón yordle que lanza bombas en 'League of Legends'?",
        R.drawable.ziggs,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Teemo", false),
            Question.Answer("Heimerdinger", false),
            Question.Answer("Tristana", false),
            Question.Answer("Ziggs", true)
        ),
        false
    ),
    Question(
        "Medium 2",
        "¿En qué serie de anime los personajes buscan las 'Esferas del Dragón'?",
        R.drawable.esferas_dragonball,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("One Piece", false),
            Question.Answer("Naruto", false),
            Question.Answer("Dragon Ball", true),
            Question.Answer("Bleach", false)
        ),
        false
    ),
    Question(
        "Medium 3",
        "¿Cómo se llama la espada del personaje Cloud Strife en 'Final Fantasy VII'?",
        R.drawable.cloud,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Excalibur", false),
            Question.Answer("Masamune", false),
            Question.Answer("Buster Sword", true),
            Question.Answer("Soul Edge", false)
        ),
        false
    ),
    Question(
        "Medium 4",
        "¿En qué ciudad ficticia se desarrolla la serie 'Stranger Things'?",
        R.drawable.stranger_things,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Hawkins", true),
            Question.Answer("Springfield", false),
            Question.Answer("Riverdale", false),
            Question.Answer("Hill Valley", false)
        ),
        false
    ),
    Question(
        "Medium 5",
        "¿Cuál es el nombre del personaje principal en 'The Legend of Zelda'?",
        R.drawable.link,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Ganondorf", false),
            Question.Answer("Link", true),
            Question.Answer("Zelda", false),
            Question.Answer("Impa", false)
        ),
        false
    ),
    Question(
        "Medium 6",
        "¿Quién es el creador de la serie de cómics 'Spider-Man'?",
        R.drawable.spiderman,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Stan Lee", true),
            Question.Answer("Jack Kirby", false),
            Question.Answer("Frank Miller", false),
            Question.Answer("Alan Moore", false)
        ),
        false
    ),
    Question(
        "Medium 7",
        "¿En qué año se lanzó el primer videojuego de 'Super Mario Bros.'?",
        R.drawable.mario,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("1983", false),
            Question.Answer("1985", true),
            Question.Answer("1990", false),
            Question.Answer("1992", false)
        ),
        false
    ),
    Question(
        "Medium 8",
        "¿Cuál es el nombre del protagonista en la serie de televisión 'Doctor Who'?",
        R.drawable.doctor_who,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Captain Jack Harkness", false),
            Question.Answer("The Doctor", true),
            Question.Answer("Rose Tyler", false),
            Question.Answer("River Song", false)
        ),
        false
    ),
    Question(
        "Medium 9",
        "¿En qué videojuego de rol puedes encontrar a los personajes Tidus y Yuna?",
        R.drawable.ffx,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Final Fantasy VIII", false),
            Question.Answer("Final Fantasy X", true),
            Question.Answer("Final Fantasy VII", false),
            Question.Answer("Final Fantasy IX", false)
        ),
        false
    ),
    Question(
        "Medium 10",
        "¿Cuál es el nombre del androide verde en 'Dragon Ball Z'?",
        R.drawable.android_16,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Android 17", false),
            Question.Answer("Android 18", false),
            Question.Answer("Android 16", true),
            Question.Answer("Cell", false)
        ),
        false
    ),
    Question(
        "Medium 11",
        "¿En qué año se lanzó la primera película de 'Star Wars'?",
        R.drawable.star_wars,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("1975", false),
            Question.Answer("1977", true),
            Question.Answer("1980", false),
            Question.Answer("1983", false)
        ),
        false
    ),
    Question(
        "Medium 12",
        "¿Cuál es el nombre del personaje principal en la serie 'Breaking Bad'?",
        R.drawable.breaking_bad,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Walter White", true),
            Question.Answer("Jesse Pinkman", false),
            Question.Answer("Saul Goodman", false),
            Question.Answer("Hank Schrader", false)
        ),
        false
    ),
    Question(
        "Medium 13",
        "¿Cuál es el nombre del personaje principal en 'Assassin's Creed'?",
        R.drawable.assassins_creed,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Ezio Auditore", false),
            Question.Answer("Altair Ibn-La'Ahad", false),
            Question.Answer("Connor Kenway", false),
            Question.Answer("Desmond Miles", true)
        ),
        false
    ),
    Question(
        "Medium 14",
        "¿A que campeón del lol pertenece esta habilidad?",
        R.drawable.sennacurse,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Janna", false),
            Question.Answer("Zyra", false),
            Question.Answer("Senna", true),
            Question.Answer("Gragas", false)
        ),
        false
    ),
    Question(
        "Medium 15",
        "¿A que obra pertenece el grupo SEX-BOB-OMB?",
        R.drawable.sexbobomb,
        Question.Difficulty.MEDIUM,
        listOf(
            Question.Answer("Acero Puro", false),
            Question.Answer("Titanic", false),
            Question.Answer("Scott Pilgrim vs the World", true),
            Question.Answer("Twisted Metals", false)
        ),
        false
    )
)

val hardQuestions = listOf(
    Question(
        "Hard 1",
        "¿A que juego pertenece este personaje?",
        R.drawable.neonagent,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Valorant", true),
            Question.Answer("Prince of persia", false),
            Question.Answer("League of Legends", false),
            Question.Answer("Tales of Zestiria", false)
        ),
        false
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
        ),
        false
    ),
    Question(
        "Hard 3",
        "¿Cuál es el nombre del anime del protagonista Shinichi Izumi?",
        R.drawable.parasyte,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Parasyte", true),
            Question.Answer("Magi", false),
            Question.Answer("Jujutsu Kaisen", false),
            Question.Answer("Madokka Magica", false)
        ),
        false
    ),
    Question(
        "Hard 4",
        "¿En qué anime los personajes luchan contra 'Homúnculos'?",
        R.drawable.fma_homunculus,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Attack on Titan", false),
            Question.Answer("Tokyo Ghoul", false),
            Question.Answer("Fullmetal Alchemist: Brotherhood", true),
            Question.Answer("Hunter x Hunter", false)
        ),
        false
    ),
    Question(
        "Hard 5",
        "¿A qué anime pertenece el equipo de fútbol Raimon?",
        R.drawable.inazuma_eleven,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Inazuma Eleven", true),
            Question.Answer("Captain Tsubasa", false),
            Question.Answer("Haikyuu!!", false),
            Question.Answer("Kuroko no Basket", false)
        ),
        false
    ),
    Question(
        "Hard 6",
        "¿En TU CARA ME SUENA, quien canta la cancion de OLIVER Y BENJI?",
        R.drawable.oliver_and_benji,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Rafael y Miquel Montoro", false),
            Question.Answer("Miki Nadal y Fran", true),
            Question.Answer("Ibai Llanos y Ander Cortés", false),
            Question.Answer("Belen Esteban y Santiago Segura", false)
        ),
        false
    ),
    Question(
        "Hard 7",
        "¿Cuál era el gitano de Oliver y Benji?",
        R.drawable.gitanobenji,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Mark Lenders/Hyuga", true),
            Question.Answer("Oliver/Tsubasa", false),
            Question.Answer("Roberto/Roberto", false),
            Question.Answer("Los gemelos Derrick", false)
        ),
        false
    ),
    Question(
        "Hard 8",
        "¿En qué anime los personajes utilizan 'Nen' para luchar?",
        R.drawable.hunterxhunter_nen,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Naruto", false),
            Question.Answer("One Piece", false),
            Question.Answer("Hunter x Hunter", true),
            Question.Answer("Bleach", false)
        ),
        false
    ),
    Question(
        "Hard 9",
        "¿Cuál es el nombre del protagonista en 'Cowboy Bebop'?",
        R.drawable.cowboy_bebop,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Jet Black", false),
            Question.Answer("Spike Spiegel", true),
            Question.Answer("Faye Valentine", false),
            Question.Answer("Edward Wong", false)
        ),
        false
    ),
    Question(
        "Hard 10",
        "¿Cuál es el nombre del protagonista en 'Ghost in the Shell'?",
        R.drawable.ghost_in_the_shell,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Motoko Kusanagi", true),
            Question.Answer("Batou", false),
            Question.Answer("Togusa", false),
            Question.Answer("Daisuke Aramaki", false)
        ),
        false
    ),
    Question(
        "Hard 11",
        "¿Como se llama el protagonista de 'Tokyo Ghoul'?",
        R.drawable.tokyo_ghoul,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Yuno Gasai", false),
            Question.Answer("Asta", false),
            Question.Answer("Kaneki Ken", true),
            Question.Answer("Freezer", false)
        ),
        false
    ),
    Question(
        "Hard 12",
        "¿A qué anime pertenece el personaje Kenzo Tenma?",
        R.drawable.monster,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Monster", true),
            Question.Answer("Death Note", false),
            Question.Answer("Steins;Gate", false),
            Question.Answer("Paranoia Agent", false)
        ),
        false
    ),
    Question(
        "Hard 13",
        "¿En qué anime los personajes tienen un dispositivo llamado 'DigiVice'?",
        R.drawable.digimon,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Pokémon", false),
            Question.Answer("Digimon", true),
            Question.Answer("Yu-Gi-Oh!", false),
            Question.Answer("Cardcaptor Sakura", false)
        ),
        false
    ),
    Question(
        "Hard 14",
        "¿Cuál es el nombre del protagonista en 'Elfen Lied'?",
        R.drawable.elfen_lied,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Lucy", true),
            Question.Answer("Kohta", false),
            Question.Answer("Nana", false),
            Question.Answer("Mayu", false)
        ),
        false
    ),
    Question(
        "Hard 15",
        "¿En qué anime los personajes participan en el 'Santo Grial de la Guerra'?",
        R.drawable.fatezero,
        Question.Difficulty.HARD,
        listOf(
            Question.Answer("Fate/stay night", false),
            Question.Answer("Fate/Zero", true),
            Question.Answer("Fate/Apocrypha", false),
            Question.Answer("Fate/Grand Order", false)
        ),
        false
    )
)