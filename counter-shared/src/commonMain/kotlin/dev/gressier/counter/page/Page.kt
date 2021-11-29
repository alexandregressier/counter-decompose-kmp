package dev.gressier.counter.page

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
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
    componentContext: ComponentContext,
    title: String,
) : Page, ComponentContext by componentContext {

    override val models: MutableValue<Page.Model> = MutableValue(Page.Model(title))

    override val counter: Counter = CounterComponent(childContext(key = "Counter"))
    override val itemList: ItemList = ItemListComponent()
    override val editor: Editor = EditorComponent(onAdd = itemList::add)
}