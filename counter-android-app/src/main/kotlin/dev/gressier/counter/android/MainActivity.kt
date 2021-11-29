package dev.gressier.counter.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import dev.gressier.counter.android.ui.RootUi
import dev.gressier.counter.android.ui.theme.CounterTheme
import dev.gressier.counter.root.RootComponent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = RootComponent(defaultComponentContext())

        setContent {
            CounterTheme {
                RootUi(root)
            }
        }
    }
}