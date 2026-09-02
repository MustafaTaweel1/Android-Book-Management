# 📚 Kitabi - Android Book Management App

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-7F52FF.svg?style=flat&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose%20(Material%203)-4285F4.svg?style=flat&logo=android&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Room Database](https://img.shields.io/badge/Database-Room%202.6.1-47A248.svg?style=flat&logo=sqlite&logoColor=white)](https://developer.android.com/training/data-storage/room)
[![Architecture](https://img.shields.io/badge/Architecture-MVVM-orange.svg?style=flat)]()
[![Platform](https://img.shields.io/badge/Platform-Android%20(API%2027--35)-green.svg?style=flat&logo=android)](https://www.android.com/)

A modern, native Android application designed to manage your personal book collection effortlessly. Built with **Kotlin**, **Jetpack Compose (Material 3)**, and **Room Database**, following the **MVVM (Model-View-ViewModel)** architectural pattern.

---

## 🌟 Key Features

- 📖 **Book Catalog / List View (`BookListActivity`)**: Browse all stored books in a responsive LazyColumn card list with real-time reactive updates using Kotlin `Flow` & `StateFlow`.
- ➕ **Add New Books (`InsertBookActivity`)**: Seamlessly insert new books with title and author validation.
- 🔍 **Book Details (`BookDetailActivity`)**: View full details for any selected book from the library.
- 🗑️ **Delete Book**: Remove books instantly from the local database with interactive action buttons.
- 💾 **Local Offline Storage (Room DB)**: Robust SQLite data persistence ensuring your book records remain saved across device reboots.
- 🎨 **Modern UI (Material 3)**: Clean, sleek, and intuitive user interface built purely with Jetpack Compose.
- 🌐 **Arabic Localization**: Native Arabic UI headers and labels for an optimized local user experience.

---

## 🏗️ Architecture & Tech Stack

The application follows Google's recommended **MVVM (Model-View-ViewModel)** architecture for separation of concerns and maintainability:

```
┌──────────────────────────────────────────────┐
│             UI Layer (Views)                 │
│ MainActivity | BookListActivity | Insert...  │
│          (Jetpack Compose Material 3)        │
└──────────────────────┬───────────────────────┘
                       │ Observes StateFlow / Events
┌──────────────────────▼───────────────────────┐
│                 ViewModel                    │
│              (BookViewModel)                 │
│         (Kotlin Coroutines & Flow)           │
└──────────────────────┬───────────────────────┘
                       │ DAO Queries
┌──────────────────────▼───────────────────────┐
│               Data Layer                     │
│      Room Database (AppDatabase & BookDao)   │
│                 SQLite DB                    │
└──────────────────────────────────────────────┘
```

### Technologies Used:
- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Toolkit**: [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material Design 3
- **Local Database**: [Android Room Persistence Library](https://developer.android.com/training/data-storage/room) (version 2.6.1) with KSP (Kotlin Symbol Processing)
- **Asynchronous Programming**: Kotlin Coroutines & `Flow` / `StateFlow`
- **State Management**: Android Architecture Components `ViewModel`
- **Build System**: Gradle Kotlin DSL (`build.gradle.kts`)

---

## 📁 Project Structure

```
app/src/main/java/com/example/book/
├── AppDatabase.kt          # Room Database singleton configuration
├── Book.kt                 # Room Entity representing a Book (id, title, author)
├── BookDao.kt              # Data Access Object with CRUD queries & Flow stream
├── BookViewModel.kt        # ViewModel handling state and coroutine database operations
├── BookViewModelFactory.kt # ViewModel factory provider
├── MainActivity.kt         # Entry point activity with primary navigation actions
├── BookListActivity.kt     # Screen displaying the book list with delete actions
├── InsertBookActivity.kt   # Form screen to input and save new books
├── BookDetailActivity.kt   # Screen displaying specific book information
├── BookApp.kt              # Composable components
└── ui/theme/               # Material 3 Compose theme, typography, and color tokens
```

---

## 🚀 Getting Started

### Prerequisites
- **Android Studio** (Koala / Ladybug or newer recommended)
- **JDK 11** or **JDK 17**
- **Android SDK** (API Level 27 minimum, target API Level 34/35)
- Android device or Emulator running Android 8.1 (API 27) or higher

### Installation & Execution

1. **Clone or Open the Repository**:
   Open the project folder in Android Studio:
   ```bash
   git clone <repository-url>
   ```

2. **Sync Gradle**:
   Allow Android Studio to sync the project dependencies via Gradle.

3. **Build the Project**:
   ```bash
   ./gradlew build
   ```

4. **Run the App**:
   Select your connected device or emulator and press **Run (Shift + F10)**.

---

## 🔮 Roadmap & Future Enhancements

- [ ] Book Categories / Tags (e.g., Fiction, Science, History)
- [ ] Book Cover Image Upload / Camera scanner for ISBN barcodes
- [ ] Reading Progress Tracker (e.g., Currently Reading, Completed, Wishlist)
- [ ] Search & Filter books by title or author
- [ ] Dark Mode / Light Mode toggle

---

## 📄 License
This project was developed for educational and portfolio purposes. Feel free to use and extend it!
