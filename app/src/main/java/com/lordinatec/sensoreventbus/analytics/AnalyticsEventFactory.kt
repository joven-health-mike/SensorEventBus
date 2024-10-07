package com.lordinatec.sensoreventbus.analytics

import com.lordinatec.sensoreventbus.analytics.event.AirplaneModeAnalyticsEvent
import com.lordinatec.sensoreventbus.analytics.event.AnalyticsEvent
import com.lordinatec.sensoreventbus.analytics.event.TrafficStatsAnalyticsEvent
import com.lordinatec.sensoreventbus.sensor.event.SensorEvent

object AnalyticsEventFactory {
    fun create(event: SensorEvent): AnalyticsEvent {
        when (event) {
            is SensorEvent.AirplaneModeEvent -> {
                return AirplaneModeAnalyticsEvent(
                    eventName = "AirplaneModeEvent",
                    timestamp = System.currentTimeMillis(),
                    isEnabled = event.isEnabled
                )
            }

            is SensorEvent.TrafficStatsEvent -> {
                return TrafficStatsAnalyticsEvent(
                    eventName = "TrafficStatsEvent",
                    timestamp = System.currentTimeMillis(),
                    receivedBytes = event.receivedBytes,
                    sentBytes = event.sentBytes
                )
            }

            else -> {
                throw IllegalArgumentException("Unknown event type")
            }
        }
    }
}
