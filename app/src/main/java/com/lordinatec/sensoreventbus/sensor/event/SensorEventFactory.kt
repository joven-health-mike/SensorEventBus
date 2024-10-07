package com.lordinatec.sensoreventbus.sensor.event

object SensorEventFactory {
    fun createAirplaneModeEvent(isEnabled: Boolean): SensorEvent.AirplaneModeEvent {
        return SensorEvent.AirplaneModeEvent(
            isEnabled = isEnabled
        )
    }

    fun createTrafficStatsEvent(
        receivedBytes: Long,
        sentBytes: Long
    ): SensorEvent.TrafficStatsEvent {
        return SensorEvent.TrafficStatsEvent(
            receivedBytes = receivedBytes,
            sentBytes = sentBytes
        )
    }
}
