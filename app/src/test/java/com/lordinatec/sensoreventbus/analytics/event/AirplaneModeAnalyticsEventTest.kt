package com.lordinatec.sensoreventbus.analytics.event

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AirplaneModeAnalyticsEventTest {
    @Test
    fun testToJson() {
        val event = AirplaneModeAnalyticsEvent(
            id = 1,
            eventName = "AirplaneMode",
            timestamp = 123456789,
            isEnabled = true
        )
        val expected = """{
            "event_name": "AirplaneMode",
            "timestamp": 123456789,
            "isEnabled": true
        }""".trimIndent()
        assertEquals(expected, event.toJson())
    }
}