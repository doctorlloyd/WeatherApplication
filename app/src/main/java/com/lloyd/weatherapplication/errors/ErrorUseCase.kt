package com.lloyd.weatherapplication.errors

import com.lloyd.weatherapplication.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}