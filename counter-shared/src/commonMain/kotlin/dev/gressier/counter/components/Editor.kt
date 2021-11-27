package dev.gressier.counter.components

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.reduce

interface Editor {

    val models: Value<Model>

    fun onTextChange(text: String)

    data class Model(
        val text: String = "",
    )
}

class EditorComponent : Editor {

    private val _models = MutableValue(Editor.Model())
    override val models: Value<Editor.Model> = _models

    override fun onTextChange(text: String) {
        _models.reduce { it.copy(text = text) }
    }
}