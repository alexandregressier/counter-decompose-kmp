package dev.gressier.counter.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.gressier.counter.page.Page

@Composable
fun PageUi(component: Page, modifier: Modifier = Modifier) {
    Column(modifier) {
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