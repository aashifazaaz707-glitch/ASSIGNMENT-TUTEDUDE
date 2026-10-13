# ShopEase - E-Commerce Platform Android Application

An Android E-Commerce application built using modern Android development practices, **MVVM architecture**, **Jetpack Compose (Material 3)**, **Hilt Dependency Injection**, **Room Local Database**, **Firebase Authentication & Firestore**, and **Retrofit with FakeStore API**.

Assignment Submission for: **TuteDude Android Development Course**

---

## Architecture & Tech Stack

- **Language:** Kotlin
- **Architecture:** MVVM (Model-View-ViewModel) + Repository Pattern
- **UI Framework:** Jetpack Compose with Material Design 3
- **Dependency Injection:** Hilt (Dagger Hilt)
- **Local Persistence:** Room Database (for Favorites cache)
- **Backend / Cloud:**
  - Firebase Authentication (Email/Password registration & login)
  - Firebase Firestore (Cloud database for user-uploaded products & seller info)
- **Network / API:** Retrofit 2 + Gson Converter + OkHttp Logging (FakeStore API recommendations)
- **Image Loading:** Coil for Compose
- **Async & Reactive:** Kotlin Coroutines & StateFlow

---

## Features Implemented

### 1. Authentication (Firebase Auth)
- User Registration with name, email, and password validation (min 6 characters).
- User Login with real-time error handling.
- Persistent session handling (auto-navigates to Home if logged in).

### 2. Home Screen & Marketplace
- Displays real-time user-uploaded products fetched from Firestore.
- Each product card displays:
  - Product thumbnail
  - Title
  - Short description
  - Price & category tag
- Search bar to filter products in real-time by keyword.
- Category filter chips (Electronics, Fashion, Home, Sports, Books).

### 3. Recommended Products (FakeStore API Integration)
- Integrated public [FakeStore API](https://fakestoreapi.com/products) using **Retrofit**.
- Displayed in a horizontal row under the "Recommended for You" section.

### 4. Product Details Screen
- Image gallery displaying product pictures.
- Price, category badge, and complete product description.
- Seller / Uploader details card (Seller name, contact email, and phone number).
- Real-time **Add to Favorites** button with dynamic heart icon state.

### 5. Upload Product
- Dedicated screen allowing registered users to post their own items for sale.
- Inputs for:
  - Title
  - Description
  - Price
  - Category selection dropdown
  - Minimum 3 image URLs
  - Seller phone number
- Stored directly into Firebase Firestore.

### 6. Favorites (Room Local Database)
- Offline-first Room Database architecture (`FavoriteProductEntity`, `FavoriteProductDao`, `AppDatabase`).
- Accessible from the Home screen top bar.
- Allows users to view saved products offline or remove them with a single tap.

---

## Project Structure

```text
EcommerceApp/
├── app/
│   ├── build.gradle.kts
│   ├── google-services.json
│   ├── src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── java/com/tutedude/ecommerce/
│   │   │   ├── EcommerceApp.kt
│   │   │   ├── MainActivity.kt
│   │   │   ├── data/
│   │   │   │   ├── local/             # Room DB: Entity, Dao, Database
│   │   │   │   ├── remote/            # Retrofit API & Data Models
│   │   │   │   └── repository/        # AuthRepository, ProductRepository, FavoriteRepository
│   │   │   ├── di/                    # Hilt Modules (Database, Network, Firebase)
│   │   │   ├── ui/
│   │   │   │   ├── navigation/        # Screen definitions & NavGraph
│   │   │   │   ├── theme/             # Material 3 Colors, Typography & Theme
│   │   │   │   └── screens/
│   │   │   │       ├── auth/          # Login & Register UI + ViewModel
│   │   │   │       ├── home/          # Home marketplace UI + ViewModel
│   │   │   │       ├── details/       # Product details UI + ViewModel
│   │   │   │       ├── upload/        # Product upload UI + ViewModel
│   │   │   │       └── favorites/     # Room favorites UI + ViewModel
│   │   │   └── util/                  # Resource state wrapper
│   │   └── res/                       # Values, drawables, strings
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

---

## Setup & Running the Application

### Prerequisites:
1. **Android Studio** (Hedgehog 2023.1 or newer recommended).
2. **JDK 17** installed and configured in Android Studio.
3. Android device or emulator running **API 24+** (Android 7.0 or higher).

### Step 1: Open Project in Android Studio
1. Launch Android Studio.
2. Select **Open** and choose the `EcommerceApp` folder.
3. Wait for Gradle Sync to complete.

### Step 2: Configure Firebase (Optional for testing your own cloud project)
1. Go to [Firebase Console](https://console.firebase.google.com/) and create a project.
2. Enable **Authentication** (Email/Password provider).
3. Enable **Cloud Firestore** in test mode.
4. Download your `google-services.json` and replace the placeholder file at `EcommerceApp/app/google-services.json`.

### Step 3: Run the App / Generate APK
- Click the green **Run (▶)** button in Android Studio to install on your emulator or connected device.
- To generate the APK:
  - In Android Studio: **Build > Build Bundle(s) / APK(s) > Build APK(s)**
  - Via command line:
    ```bash
    ./gradlew assembleDebug
    ```
  - The compiled APK is available at:
    - [ShopEase-debug.apk](file:///home/azazlab/Desktop/project%20file/EcommerceApp/ShopEase-debug.apk) (Convenience copy in `EcommerceApp/`)
    - [app-debug.apk](file:///home/azazlab/Desktop/project%20file/EcommerceApp/app/build/outputs/apk/debug/app-debug.apk)

