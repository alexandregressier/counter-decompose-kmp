package dev.gressier.counter.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.push
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import dev.gressier.counter.page.PageComponent
import dev.gressier.counter.root.Root.Child

interface Root {

    val routerState: Value<RouterState<*, Child>>

    fun onNext()

    fun onPrevious()

    sealed class Child {
        class Page(val component: dev.gressier.counter.page.Page) : Child()
    }
}

class RootComponent(
    componentContext: ComponentContext,
) : Root, ComponentContext by componentContext {

    private val router =
        router<Config, Child>(
            initialConfiguration = Config.Page(index = 0),
            childFactory = ::child,
        )
    override val routerState: Value<RouterState<*, Child>> = router.state

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Config.Page ->
                Child.Page(component = PageComponent(title = "Page #${config.index}"))
        }

    override fun onNext() {
        router.push(Config.Page(router.state.value.backStack.size + 1))
    }

    override fun onPrevious() {
        router.pop()
    }

    private sealed class Config : Parcelable {
        @Parcelize data class Page(val index: Int) : Config()
    }
}