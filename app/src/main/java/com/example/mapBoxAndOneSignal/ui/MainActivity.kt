package com.example.mapBoxAndOneSignal.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
   val viewModel: MainViewModel by inject ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel = viewModel)
        }
    }
}