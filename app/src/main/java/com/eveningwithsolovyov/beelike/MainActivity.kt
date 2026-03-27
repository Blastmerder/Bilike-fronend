package com.eveningwithsolovyov.beelike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.eveningwithsolovyov.beelike.navigation.NavigationRoot
import com.eveningwithsolovyov.beelike.ui.theme.BeelikeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeelikeTheme {
                NavigationRoot()
            }
        }
    }
}
