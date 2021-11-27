package dev.gressier.counter.components

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.reduce

interface Counter {

    val models: Value<Model>

    fun onIncrement()

    fun onDecrement()

    data class Model(
        val count: Int = 0,
    )
}

class CounterComponent : Counter {

    private val _models = MutableValue(Counter.Model())
    override val models: Value<Counter.Model> = _models

    override fun onIncrement() {
        _models.reduce { it.copy(count = it.count + 1) }
    }

    override fun onDecrement() {
        _models.reduce { it.copy(count = it.count - 1) }
    }
}