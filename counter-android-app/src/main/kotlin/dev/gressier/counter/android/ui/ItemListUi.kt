package dev.gressier.counter.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import dev.gressier.counter.components.ItemList

@Composable
fun ItemListUi(component: ItemList, modifier: Modifier = Modifier) {

    val model by component.models.subscribeAsState()

    LazyColumn(modifier) {
        items(model.items) { item ->
            Text(item, Modifier.padding(16.dp))
        }
    }
}