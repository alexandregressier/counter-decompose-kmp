package dev.gressier.counter.components

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface ItemList {

    val models: Value<Model>

    data class Model(
        val items: List<String>,
)
}

class ItemListComponent : ItemList {

    override val models: Value<ItemList.Model> =
        MutableValue(ItemList.Model(items = List(100) { "Item #$it" }))
}