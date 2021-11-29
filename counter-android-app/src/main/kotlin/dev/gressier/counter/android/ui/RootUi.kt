package dev.gressier.counter.android.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.animation.child.slide
import dev.gressier.counter.root.Root

@Composable
fun RootUi(component: Root) {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth()) {
            IconButton(component::onPrevious) {
                Icon(Icons.Default.ArrowBack, "Button previous")
            }
            Box(Modifier.weight(1f))
            IconButton(component::onNext) {
                Icon(Icons.Default.ArrowForward, "Button next")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            Children(component.routerState, animation = slide()) {
                when (val child = it.instance) {
                    is Root.Child.Page -> PageUi(child.component, Modifier.fillMaxSize())
                }
            }
        }
    }
}