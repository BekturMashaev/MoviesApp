package com.example.movieapp.presentation.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import androidx.core.app.ComponentActivity

@SuppressLint("RestrictedApi")
fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}

