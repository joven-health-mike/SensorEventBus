package com.lordinatec.sensoreventbus

object AnalyticsManager {
    fun onAirplaneModeChanged(isOn: Boolean) {
        val event = if (isOn) "AirplaneModeOn" else "AirplaneModeOff"
        val analyticsEvent = AnalyticsEvent(event, System.currentTimeMillis())
        AnalyticsRepository.sendEvent(analyticsEvent)
    }

    fun onTrafficStatsUpdated(receivedBytes: Long, sentBytes: Long) {
        val event = AnalyticsEvent("TrafficStats", System.currentTimeMillis(), receivedBytes, sentBytes)
        AnalyticsRepository.sendEvent(event)
    }
}