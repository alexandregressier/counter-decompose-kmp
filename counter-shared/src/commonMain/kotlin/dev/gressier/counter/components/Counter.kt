package dev.gressier.counter.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.reduce
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.essenty.statekeeper.consume

interface Counter {

    val models: Value<Model>

    fun onIncrement()

    fun onDecrement()

    @Parcelize
    data class Model(
        val count: Int = 0,
    ) : Parcelable
}

class CounterComponent(
    componentContext: ComponentContext,
) : Counter, ComponentContext by componentContext {

    private val _models =
        MutableValue(stateKeeper.consume<Counter.Model>(key = "STATE") ?: Counter.Model())

    override val models: Value<Counter.Model> = _models

    init {
        stateKeeper.register(key = "STATE") { _models.value }
    }

    override fun onIncrement() {
        _models.reduce { it.copy(count = it.count + 1) }
    }

    override fun onDecrement() {
        _models.reduce { it.copy(count = it.count - 1) }
    }
}