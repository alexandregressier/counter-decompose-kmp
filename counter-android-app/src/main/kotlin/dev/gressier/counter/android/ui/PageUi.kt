package dev.gressier.counter.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import dev.gressier.counter.page.Page

@Composable
fun PageUi(component: Page, modifier: Modifier = Modifier) {

    val model by component.models.subscribeAsState()

    Column(modifier) {
        Text(
            model.title,
            Modifier.align(Alignment.CenterHorizontally),
        )
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            CounterUi(
                component.counter,
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
            )
            ItemListUi(
                component.itemList,
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
            )
        }
        EditorUi(
            component.editor,
            Modifier.fillMaxWidth(),
        )
    }
}