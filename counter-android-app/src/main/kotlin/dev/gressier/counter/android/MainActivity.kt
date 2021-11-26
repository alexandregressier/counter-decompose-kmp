package dev.gressier.counter.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.gressier.counter.android.ui.theme.CounterTheme
import dev.gressier.counter.Greeting

class MainActivity : ComponentActivity() {

    private val greet = Greeting().greeting()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterTheme {
                Box(Modifier.fillMaxSize(), Alignment.Center) {
                    Text(greet)
                }
            }
        }
    }
}