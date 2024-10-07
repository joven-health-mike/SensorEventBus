package com.lordinatec.sensoreventbus.sensor.event

object SensorEventFactory {
    fun createAirplaneModeEvent(isEnabled: Boolean): AirplaneModeEvent {
        return AirplaneModeEvent(timestamp = System.currentTimeMillis(), isEnabled = isEnabled)
    }

    fun createTrafficStatsEvent(receivedBytes: Long, sentBytes: Long): TrafficStatsEvent {
        return TrafficStatsEvent(
            timestamp = System.currentTimeMillis(),
            receivedBytes = receivedBytes,
            sentBytes = sentBytes
        )
    }
}