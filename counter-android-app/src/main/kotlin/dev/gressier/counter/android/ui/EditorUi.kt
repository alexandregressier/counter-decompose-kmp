package dev.gressier.counter.android.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import dev.gressier.counter.components.Editor

@Composable
fun EditorUi(component: Editor, modifier: Modifier = Modifier) {

    val model by component.models.subscribeAsState()

    Row(modifier) {
        TextField(model.text, component::onTextChange, Modifier.weight(1f))
        IconButton(component::onItemAdd) {
            Icon(Icons.Default.Add, contentDescription = "Add item button")
        }
    }

}

@Preview
@Composable
fun EditorUi_Preview() {
    EditorUi(EditorPreview)
}

private object EditorPreview : Editor {
    override val models: Value<Editor.Model> =
        MutableValue(Editor.Model(text = "Some text"))

    override fun onTextChange(text: String) {}
    override fun onItemAdd() {}
}