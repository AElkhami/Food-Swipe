package com.ellkhamitech.foodswipe.presentation.util

/**
 * Created by A.Elkhami on 23,April,2022
 */
sealed class UiEvent {
    data class ShowSnackBar(val message: UiText) : UiEvent()
}