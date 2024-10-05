package com.lordinatec.sensoreventbus

class AnalyticsEvent(
    val eventName: String,
    val timestamp: Long,
    val receivedBytes: Long? = null,
    val sentBytes: Long? = null
) {
    fun toJson(): String {
        return """{
            "event_name": "$eventName",
            "timestamp": $timestamp,
            ${receivedBytes?.let { """"receivedBytes": $receivedBytes,""" } ?: ""}
            ${sentBytes?.let { """"sentBytes": $sentBytes""" } ?: ""}
        }""".trimIndent()
    }
}