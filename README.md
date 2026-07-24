<div align="center">
# 🎯 Trivial App
**A native Android Trivia & Quiz game built with Kotlin, Jetpack Compose, and Material 3 design.**
[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Min SDK](https://img.shields.io/badge/Min%20SDK-24-orange?style=for-the-badge)](https://developer.android.com)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-34-blue?style=for-the-badge)](https://developer.android.com)
<br />
<p align="center">
  <img src="https://sergiherrador.com/trivial/trivia-main-menu-light.webp" alt="Trivial App Menu" width="250" />
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://sergiherrador.com/trivial/trivia-gameplay-cowboy-bebop.webp" alt="Trivial App Gameplay" width="250" />
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://sergiherrador.com/trivial/trivia-results-perfect-score.webp" alt="Trivial App Results" width="250" />
</p>
</div>
---
## 🌟 Overview
**Trivial App** is an interactive, fast-paced mobile quiz application designed for Android. It features dynamic round progression, multiple difficulty tiers, timed questions with visual feedback, real-time score multipliers, dark & light theme modes, and persistent high scores.
---
## ✨ Key Features
- 🎮 **Dynamic Quiz Engine**: Round-based state machine managing timer countdowns, answer validation, and score calculation.
- ⏱️ **Countdown Timer**: Real-time timer per question with visual time-bar and penalty triggers.
- 🏆 **Score Multipliers & Streaks**: Consecutive correct answers grant bonus multiplier points.
- 🎨 **Dark & Light Mode**: Seamless Material 3 theme switching for customized visual comfort.
- 💾 **Local Score Persistence**: Saves high scores, win streaks, and game history locally using `SharedPreferences`.
- 📱 **Declarative UI**: Built with Jetpack Compose, optimized across phone screen densities.
---
## 🛠 Tech Stack & Architecture
- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Toolkit**: [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material Design 3
- **Architecture**: MVVM (Model-View-ViewModel) + Game State Machine
- **State Management**: `StateFlow` / `LiveData` & `ViewModel`
- **Storage**: `SharedPreferences` for local high scores & user settings
- **Build System**: Gradle with Kotlin DSL (`build.gradle.kts`)
TrivialApp/ ├── engine/ # State machine managing rounds, timer ticks, and scoring logic ├── data/ # Question repository & Local storage (SharedPreferences) ├── viewmodel/ # QuizViewModel handling state emission & reactive UI streams └── ui/ # Jetpack Compose screens (MenuScreen, GameplayScreen, ResultsScreen)

---
## 🚀 Getting Started
### Prerequisites
- **Android Studio**: Jellyfish (2024.1.1) or newer
- **JDK**: Version 17
- **Minimum SDK**: 24 (Android 7.0 Nougat)
- **Target SDK**: 34 (Android 14)
### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/sergiherradorITB/TrivialApp_SergiHerrador.git
Open the project in Android Studio.
Allow Gradle to sync dependencies.
Run on an Android emulator or connected device (Shift + F10).
