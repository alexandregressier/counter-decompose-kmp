package dev.gressier.counter

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test fun Check_that_Hello_is_mentioned() {
        assertTrue(Greeting().greeting().contains("Hello"))
    }
}