package com.lordinatec.sensoreventbus.analytics.event

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TrafficStatsAnalyticsEventTest {
    @Test
    fun testToJson() {
        val event = TrafficStatsAnalyticsEvent(
            id = 1,
            eventName = "TrafficStats",
            timestamp = 123456789,
            receivedBytes = 100,
            sentBytes = 200
        )
        val expected = """{
            "event_name": "TrafficStats",
            "timestamp": 123456789,
            "receivedBytes": 100,
            "sentBytes": 200
        }""".trimIndent()
        assertEquals(expected, event.toJson())
    }
}