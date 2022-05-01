# Food-Swipe

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Architecture](#architecture)
* [Branches](#branches)

## General info
This project is displaying categorized food products with its details.
	
## Technologies
Project is created with:
* Kotlin
* Coroutines
* Flow
* Compose
* Hilt
* Retrofit
* OkHttp
* Coil
* Google splash screen
	
## Architecture
* MVVM 
  - The view model hold's the UI data while surviving configuration changes.
  - View model lets you do the separation by adding all the UI related variables, logic and data
    into the view model, while the Activity/Fragment will be only responsible for drawing the UI on the screen
    and receive user interactions.
* Clean Architecture
   - It makes the code easily testable.
   - Code is further decoupled.
   - Easy to maintain.
   - The package structure is easier to navigate.
   - Features can be added more easily.

## Branches

There are new branches each of them demonstrates different unit test approach.

- `mockito-unit-test` Creating a unit test using mockito library.
- `mockk-unit-test` Creating a unit test using mockk library.
- `mock-web-server-unit-test` Mocking server request while testing the repository.
