package com.lordinatec.sensoreventbus

object SensorManager {
    suspend fun onAirplaneModeChanged(isEnabled: Boolean) {
        val event = AirplaneModeEvent(timestamp = System.currentTimeMillis(), isEnabled = isEnabled)
        SensorEventManager.publishEvent(event)
    }

    suspend fun onTrafficStatsUpdated(receivedBytes: Long, sentBytes: Long) {
        val event = TrafficStatsEvent(
            timestamp = System.currentTimeMillis(),
            receivedBytes = receivedBytes,
            sentBytes = sentBytes
        )
        SensorEventManager.publishEvent(event)
    }
}
