<div align="center">

<img src="https://sergiherrador.com/trivial/trivia-icon.png" alt="Trivial App Logo" width="120" />

# Trivial App

**A native Android Trivia & Quiz game built with Kotlin, Jetpack Compose, and Material 3 design.**

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Min SDK](https://img.shields.io/badge/Min%20SDK-24-orange?style=for-the-badge)](https://developer.android.com)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-34-blue?style=for-the-badge)](https://developer.android.com)
[![Version](https://img.shields.io/badge/Version-1.0-blueviolet?style=for-the-badge)](https://github.com/sergiherradorITB/TrivialApp_SergiHerrador)

</div>

---

## Overview

Trivial App is an interactive, fast-paced mobile quiz application designed for native Android. Choose difficulty levels, category themes, and navigate multiple question rounds featuring a real-time countdown timer, dynamic scoring multipliers, dark & light theme modes, and persistent high scores.

Built as a deep dive into modern Android development: Kotlin + Jetpack Compose, state machine-driven game engine, local persistence with SharedPreferences, and clean MVVM architecture.

---

## Screenshots

<div align="center">
<table>
  <tr>
    <td align="center"><strong>Main Menu</strong></td>
    <td align="center"><strong>Gameplay — Cowboy Bebop</strong></td>
    <td align="center"><strong>Gameplay — Nichijou</strong></td>
  </tr>
  <tr>
    <td><img src="https://sergiherrador.com/trivial/trivia-main-menu-light.webp" width="220"/></td>
    <td><img src="https://sergiherrador.com/trivial/trivia-gameplay-cowboy-bebop.webp" width="220"/></td>
    <td><img src="https://sergiherrador.com/trivial/trivia-gameplay-nichijou.webp" width="220"/></td>
  </tr>
  <tr>
    <td align="center"><strong>Results — Perfect Score</strong></td>
    <td align="center"><strong>Settings — Dark Theme</strong></td>
    <td align="center"><strong>Settings — Light Theme</strong></td>
  </tr>
  <tr>
    <td><img src="https://sergiherrador.com/trivial/trivia-results-perfect-score.webp" width="220"/></td>
    <td><img src="https://sergiherrador.com/trivial/trivia-settings-dark.webp" width="220"/></td>
    <td><img src="https://sergiherrador.com/trivial/trivia-settings-light.webp" width="220"/></td>
  </tr>
</table>
</div>

---

## Demo

<div align="center">

[![Watch Demo](https://img.shields.io/badge/Watch%20Demo-sergiherrador.com-FF6B6B?style=for-the-badge)](https://sergiherrador.com/projects/trivial)

</div>

---

## Architecture

Trivial App follows **MVVM (Model-View-ViewModel)** with an integrated Game Engine State Machine for real-time round progression and timer execution.

```
com.sergi.trivialapp/
├── engine/                # Quiz Game Engine & State Machine
│   ├── TriviaGameEngine.kt # State transitions, timer ticks, round progression & scoring
│   └── TimerController.kt # Real-time countdown timer dispatcher
│
├── data/                  # Data Layer & Storage
│   ├── QuestionRepository.kt # Question data provider & category filter
│   └── PreferencesManager.kt # SharedPreferences for high scores & settings
│
├── ViewModel/             # Reactive Presentation Layer
│   └── QuizViewModel.kt    # Exposes StateFlow/LiveData for UI state
│
└── View/                  # Jetpack Compose UI Layer
    ├── MenuScreen.kt       # Main menu & difficulty selection
    ├── GameplayScreen.kt   # Interactive quiz question screen with timer
    ├── ResultsScreen.kt    # Score breakdown & victory summary
    └── SettingsScreen.kt   # Dark/light theme & sound toggles
```

---

## Tech Stack

| Layer | Technology |
|---|---|
| **Language** | Kotlin 1.9 |
| **UI** | Jetpack Compose + Material 3 |
| **Architecture** | MVVM + Game State Machine |
| **State Management** | StateFlow / LiveData + ViewModel |
| **Local Storage** | SharedPreferences (high scores & settings) |
| **Concurrency** | Kotlin Coroutines (`Dispatchers.IO` / `Main`) |
| **Target SDK** | Android 14 (API 34) |
| **Min SDK** | Android 7.0 (API 24) |
| **Build System** | Gradle KTS |

---

## Features

- **Dynamic Quiz Engine** — Round-based state machine managing timer countdowns, answer validation, and score calculation
- **Countdown Timer** — Real-time timer per question with visual time-bar and penalty triggers
- **Score Multipliers** — Consecutive correct answers grant bonus streak points
- **Dark & Light Mode** — Seamless Material 3 theme switching
- **Local Score Persistence** — Saves high scores and game history locally via SharedPreferences
- **Responsive UI** — Declarative Jetpack Compose layout optimized across phone screen densities

---

## Getting Started

**Prerequisites**
- Android Studio Jellyfish (2024.1.1) or later
- JDK 17
- Android device or emulator with API 24+

**Clone & Run**

```bash
git clone https://github.com/sergiherradorITB/TrivialApp_SergiHerrador.git

# Open in Android Studio: File → Open → select the cloned folder
# Sync Gradle and run on your device or emulator
```

---

## Author

**Sergi Herrador** — Backend Software Engineer

[![Portfolio](https://img.shields.io/badge/Portfolio-sergiherrador.com-6366F1?style=for-the-badge)](https://sergiherrador.com)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Sergi%20Herrador-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sergi-herrador)
[![GitHub](https://img.shields.io/badge/GitHub-sergiherradorITB-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/sergiherradorITB)
