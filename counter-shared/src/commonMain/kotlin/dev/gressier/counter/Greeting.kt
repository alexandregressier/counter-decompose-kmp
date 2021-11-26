package dev.gressier.counter

class Greeting {
    fun greeting(): String =
        "Hello, ${Platform().platform}!"
}