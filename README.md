# ABN Repo Viewer

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()

An Android app to browse and explore GitHub public repositories, with offline caching for seamless access.

## Table of Contents
* [General Info](#general-info)
* [Features](#features)
* [Technologies](#technologies)
* [Architecture](#architecture)
* [Modularization Strategy](#modularization-strategy)

## General Info
**ABN Repo Viewer** is an Android application that allows users to:
- Browse public GitHub repositories.
- View detailed repository information.
- Access repositories offline with caching support.

## Features
- **Browse**: Find public GitHub repositories with a seamless search experience.  
- **Repository Details**: View detailed repository information, including description and more.  
- **Offline Caching**: The app automatically caches repositories, allowing offline access.  
- **Smart Connectivity Handling**:  
  - Detects when the device is offline and retrieves data from cache.  
  - Monitors network status and automatically fetches fresh data when the connection is restored.  
- **Open in Browser**: Easily open repositories directly in your web browser from within the app.  
- **Modern UI**: Built with Jetpack Compose for a responsive, sleek, and intuitive user experience.  

## Technologies
The app is built using modern Android development tools and practices:

- **Kotlin**: For concise and expressive code.
- **Coroutines & Flow**: For efficient asynchronous programming.
- **Jetpack Compose**: For building declarative UI.
- **Koin**: Dependency injection, facilitating potential migration to Kotlin Multiplatform Mobile (KMM).
- **Ktor**: Networking library, enabling seamless migration to KMM in the future.
- **Coil**: Efficient image loading optimized for Android.

## Architecture
The app is built following the **MVVM** pattern and **Clean Architecture** principles:

- **MVVM (Model-View-ViewModel)**:
  - ViewModel holds UI data and survives configuration changes.
  - Separation of concerns: UI logic resides in ViewModel, while Activities/Fragments handle UI rendering and user interactions.

- **Clean Architecture**:
  - Improved testability and maintainability.
  - Decoupled codebase for easier feature addition and navigation.
  - Clear separation between data, domain, and presentation layers.

## Modularization Strategy
This project follows a hybrid modularization approach combining **feature-based** and **component-based** modules. This structure enhances code maintainability, testability, and scalability.

More about the approach [here](https://medium.com/@ahmedeelkhami/multi-module-architecture-in-android-5f76373a84a7).

