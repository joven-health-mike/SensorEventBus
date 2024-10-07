package com.lordinatec.sensoreventbus.analytics.event

interface AnalyticsEvent {
    val eventName: String
    val timestamp: Long
    fun toJson(): String
}
