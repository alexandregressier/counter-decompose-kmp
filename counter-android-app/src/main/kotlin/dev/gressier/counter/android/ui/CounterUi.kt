package dev.gressier.counter.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import dev.gressier.counter.components.Counter

@Composable
fun CounterUi(component: Counter, modifier: Modifier = Modifier) {

    val model by component.models.subscribeAsState()

    Column(modifier, Arrangement.Center, Alignment.CenterHorizontally) {
        Button(component::onIncrement) {
            Text("+")
        }
        Text("Count: ${model.count}")
        Button(component::onDecrement) {
            Text("-")
        }
    }
}