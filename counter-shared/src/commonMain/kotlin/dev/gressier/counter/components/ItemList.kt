package dev.gressier.counter.components

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.reduce

interface ItemList {

    val models: Value<Model>

    data class Model(
        val items: List<String>,
    )
}

class ItemListComponent : ItemList {

    private val _models = MutableValue(ItemList.Model(items = List(100) { "Item #$it" }))
    override val models: Value<ItemList.Model> = _models
}