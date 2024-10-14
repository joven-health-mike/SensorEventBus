package com.lordinatec.sensoreventbus.analytics.event

interface AnalyticsEvent {
    val id: Long
    val eventName: String
    val timestamp: Long
    fun toJson(): String

    interface Listener {
        fun onEvent(event: AnalyticsEvent)
    }
}
