package dev.gressier.counter

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test fun Check_that_iOS_is_mentioned() {
        assertTrue(Greeting().greeting().contains("iOS"))
    }
}