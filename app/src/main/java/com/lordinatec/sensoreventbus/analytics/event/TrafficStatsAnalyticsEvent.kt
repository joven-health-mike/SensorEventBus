package com.lordinatec.sensoreventbus.analytics.event

class TrafficStatsAnalyticsEvent(
    override val eventName: String,
    override val timestamp: Long,
    private val receivedBytes: Long,
    private val sentBytes: Long
) : AnalyticsEvent {
    override fun toJson(): String {
        return """{
            "event_name": "$eventName",
            "timestamp": $timestamp,
            "receivedBytes": $receivedBytes,
            "sentBytes": $sentBytes
        }""".trimIndent()
    }
}
