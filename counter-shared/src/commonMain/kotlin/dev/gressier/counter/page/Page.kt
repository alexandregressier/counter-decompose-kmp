package dev.gressier.counter.page

import dev.gressier.counter.components.*

interface Page {

    val counter: Counter
    val itemList: ItemList
    val editor: Editor
}

class PageComponent: Page {

    override val counter: Counter = CounterComponent()
    override val itemList: ItemList = ItemListComponent()
    override val editor: Editor = EditorComponent()
}