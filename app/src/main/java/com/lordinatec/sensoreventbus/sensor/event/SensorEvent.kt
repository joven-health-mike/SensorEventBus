package com.lordinatec.sensoreventbus.sensor.event

interface SensorEvent {
    data class AirplaneModeEvent(
        val isEnabled: Boolean
    ) : SensorEvent

    data class TrafficStatsEvent(
        val receivedBytes: Long,
        val sentBytes: Long
    ) : SensorEvent
}
