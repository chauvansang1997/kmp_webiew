# KMP WebView

A professional Kotlin Multiplatform (KMP) project demonstrating clean architecture, shared business logic, and platform-specific UI implementations for Android and iOS.

## Overview

This project showcases a production-ready KMP application with:
- Clean architecture with separation of concerns (data, domain, presentation layers)
- Shared business logic across Android and iOS platforms
- REST API integration using Ktor
- Dependency injection
- Proper error handling and logging
- WebView integration on both platforms

## Architecture

The project follows **Clean Architecture** principles with clear separation between layers:

```
├── shared/                          # Shared Kotlin Multiplatform module
│   ├── core/
│   │   ├── constants/              # Application constants (API, App, WebView)
│   │   ├── config/                 # Configuration classes (Network)
│   │   ├── network/                # HTTP client provider
│   │   ├── theme/                  # Shared theme (ColorPalette, ThemeConstants)
│   │   └── util/                   # Utilities (Logger, etc.)
│   ├── data/
│   │   ├── model/                  # Data Transfer Objects (DTOs)
│   │   ├── remote/                 # API interfaces and implementations
│   │   ├── repository/             # Repository implementations
│   │   └── result/                 # Result wrapper for error handling
│   ├── domain/
│   │   ├── model/                  # Domain models
│   │   ├── repository/             # Repository interfaces
│   │   └── usecase/                # Business logic use cases
│   └── di/                         # Dependency injection (SharedModule)
│   └── di/                         # Dependency injection (SharedModule)
├── androidApp/                      # Android application
│   ├── presentation/
│   │   └── main/                   # MainActivity and MainViewModel
│   ├── core/
│   │   ├── constants/              # Android-specific constants
│   │   ├── extension/              # Extension functions
│   │   └── theme/                  # Theme helpers (ColorProvider, ThemeHelper)
│   └── di/                         # Hilt dependency injection modules
└── iosApp/                         # iOS application
    └── iosApp/
        ├── Views/                  # SwiftUI views (ContentView, WebView)
        ├── ViewModels/             # MVVM ViewModels (MainViewModel)
        ├── DI/                     # Dependency injection (DIContainer)
        └── Theme/                  # Theme constants (ColorConstants, ThemeConstants)
```

## Key Features

### Shared Module (`shared`)

**Clean Architecture Layers:**

1. **Core Layer** - Foundation components
   - Constants: API endpoints, timeouts, error messages, WebView config
   - Configuration: Network settings
   - Network: HTTP client provider (Ktor)
   - Theme: Shared colors and design constants
   - Logger: Platform-agnostic logging

2. **Data Layer** - Data sources and repositories
   - Models: DTOs for API responses
   - Remote: API client using Ktor
   - Repository: Repository implementations
   - Result: Type-safe error handling wrapper

3. **Domain Layer** - Business logic
   - Models: Domain entities
   - Repository: Repository interfaces
   - UseCase: Business logic (GetTodoTitleUseCase, GetUrlUseCase)

4. **Dependency Injection**
   - SharedModule for dependency management
   - Platform-agnostic DI container

**Features:**
- RESTful API integration with JSONPlaceholder API
- Configurable HTTP client with timeout, logging, and error handling
- Type-safe Result wrapper for operations
- Comprehensive logging system
- Shared WebView configuration

### Android App (`androidApp`)

**Technology Stack:**
- **UI**: XML with ViewBinding
- **Architecture**: MVVM (Model-View-ViewModel) with Clean Architecture
- **DI**: Hilt (Dagger)
- **Coroutines**: Kotlin Flow for reactive state management
- **WebView**: Native Android WebView

**Structure:**
- **presentation/main**: MainActivity and MainViewModel
- **core/constants**: Android-specific constants
- **core/extension**: Extension functions
- **core/theme**: ColorProvider and ThemeHelper
- **di**: Hilt modules for dependency injection

**Features:**
- WebView loading configurable URL (default: sgcarmart.com)
- API call on launch displaying result in Toast
- Proper lifecycle handling
- Clean separation of concerns with presentation layer
- Theme system with Material Design
- Extension functions for cleaner code

### iOS App (`iosApp`)

**Technology Stack:**
- **UI**: SwiftUI
- **Architecture**: MVVM (Model-View-ViewModel) with Clean Architecture
- **DI**: Custom DIContainer
- **WebView**: WKWebView
- **Integration**: CocoaPods for shared framework

**Structure:**
- **Views**: SwiftUI views (ContentView, WebView)
- **ViewModels**: MVVM ViewModels (MainViewModel)
- **DI**: DIContainer for dependency injection
- **Theme**: ColorConstants and ThemeConstants matching shared theme

**Features:**
- Native WKWebView integration
- Toast-style alerts for API responses
- SwiftUI declarative UI
- MVVM architecture with dependency injection
- Theme constants matching Android/shared
- Shared business logic from KMP module

## Getting Started

### Prerequisites

- **Android**: Android Studio Arctic Fox or later
- **iOS**: Xcode 13+ and CocoaPods
- **Kotlin**: 1.9.22+
- **Java**: JDK 17+

### Setup and Run

#### Android

1. Open the project in Android Studio
2. Sync Gradle dependencies
3. Run the `androidApp` configuration
4. The app will:
   - Load sgcarmart.com in a WebView
   - Fetch a todo item from the API
   - Display the title in a Toast message

#### iOS

1. Navigate to `iosApp` directory:
   ```bash
   cd iosApp
   ```

2. Install CocoaPods dependencies:
   ```bash
   pod install
   ```

3. Open the workspace in Xcode:
   ```bash
   open iosApp.xcworkspace
   ```

4. Build and run the project in Xcode

## Dependencies

### Shared Module

- **Kotlin Coroutines** (1.7.3) - Async operations
- **Kotlinx Serialization** (1.6.2) - JSON parsing
- **Ktor Client** (2.3.7) - HTTP networking
  - Content Negotiation
  - JSON Serialization
  - Logging

### Android App

- **AndroidX Libraries**
  - Core KTX
  - AppCompat
  - Activity KTX
  - Lifecycle (Runtime & ViewModel)
- **Hilt** (2.48.1) - Dependency injection
- **Kotlin Coroutines Android** (1.7.3)

## Configuration

### API Configuration

Modify API settings in `shared/src/commonMain/kotlin/com/kmp/example/shared/core/constants/ApiConstants.kt`:

```kotlin
object ApiConstants {
    const val BASE_URL = "https://jsonplaceholder.typicode.com"

    object Timeouts {
        const val CONNECT_TIMEOUT = 15_000L
        const val READ_TIMEOUT = 15_000L
        const val WRITE_TIMEOUT = 15_000L
    }
}
```

### WebView Configuration

Modify WebView URL in `shared/src/commonMain/kotlin/com/kmp/example/shared/core/constants/WebViewConstants.kt`:

```kotlin
object WebViewConstants {
    const val DEFAULT_URL = "https://sgcarmart.com"
}
```

### Theme Configuration

The project includes a comprehensive theme and design system. See [THEME_GUIDE.md](THEME_GUIDE.md) for details.

**Shared Theme**: `shared/src/commonMain/kotlin/com/kmp/example/shared/core/theme/`
- `ColorPalette.kt` - All color definitions
- `ThemeConstants.kt` - Typography, spacing, dimensions

**Android Resources**:
- `colors.xml` - Color resources
- `themes.xml` - Material theme definitions
- `dimens.xml` - Dimension resources

**Features**:
- Light and dark mode support
- Consistent design across platforms
- Material Design principles
- 8dp grid spacing system
- Semantic color naming


## Code Quality

- **Clean Architecture**: Proper separation of concerns
- **SOLID Principles**: Applied throughout the codebase
- **Type Safety**: Result wrapper for error handling
- **Documentation**: Comprehensive KDoc comments
- **Constants Management**: Centralized configuration
- **Error Handling**: Graceful error handling with user feedback

## Project Structure Details

### Constants Organization

All constants are organized by domain:
- **ApiConstants**: API URLs, endpoints, timeouts
- **WebViewConstants**: WebView configuration
- **AppConstants**: Application-wide constants, log tags, error messages
- **AndroidConstants**: Android-specific UI constants

### Result Wrapper

The `Result` sealed class in the data layer provides type-safe error handling:

```kotlin
// Location: shared/data/result/Result.kt
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val error: ErrorType, val message: String?) : Result<Nothing>()
}

// Helper function for wrapping operations
suspend inline fun <T> resultOf(block: suspend () -> T): Result<T>
```

### Dependency Injection

- **Shared**: `SharedModule` object in `shared/di/` for cross-platform DI
- **Android**: Hilt modules in `androidApp/di/` (`WebViewModule`)
- **iOS**: Custom `DIContainer` in `iosApp/DI/` with factory methods

## Future Enhancements

- Unit tests for shared business logic
- UI tests for Android and iOS
- CI/CD pipeline configuration
- More complex use cases and features
- Offline support with local database
- Analytics integration
