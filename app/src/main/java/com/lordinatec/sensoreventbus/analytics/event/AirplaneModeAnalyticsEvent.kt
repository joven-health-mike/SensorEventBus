package com.lordinatec.sensoreventbus.analytics.event

class AirplaneModeAnalyticsEvent(
    override val id: Long,
    override val eventName: String,
    override val timestamp: Long,
    private val isEnabled: Boolean
) :
    AnalyticsEvent {
    override fun toJson(): String {
        return """{
            "event_name": "$eventName",
            "timestamp": $timestamp,
            "isEnabled": $isEnabled
        }""".trimIndent()
    }
}
