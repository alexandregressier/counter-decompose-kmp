package dev.gressier.counter.components

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.reduce

interface ItemList {

    val models: Value<Model>

    fun add(text: String)

    data class Model(
        val items: List<String>,
    )
}

class ItemListComponent : ItemList {

    private val _models = MutableValue(ItemList.Model(items = emptyList()))
    override val models: Value<ItemList.Model> = _models

    override fun add(text: String) {
        _models.reduce { it.copy(items = it.items + text) }
    }
}