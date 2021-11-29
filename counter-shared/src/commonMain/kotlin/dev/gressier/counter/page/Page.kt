package dev.gressier.counter.page

import com.arkivanov.decompose.value.MutableValue
import dev.gressier.counter.components.*

interface Page {

    val models: MutableValue<Model>

    val counter: Counter
    val itemList: ItemList
    val editor: Editor

    data class Model(
        val title: String,
    )
}

class PageComponent(
    title: String,
) : Page {

    override val models: MutableValue<Page.Model> = MutableValue(Page.Model(title))

    override val counter: Counter = CounterComponent()
    override val itemList: ItemList = ItemListComponent()
    override val editor: Editor = EditorComponent()
}