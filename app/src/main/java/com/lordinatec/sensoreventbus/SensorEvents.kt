package com.lordinatec.sensoreventbus

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class AirplaneModeEvent(
    override val eventName: String = "AirplaneMode",
    override val timestamp: Long,
    val isEnabled: Boolean
) : SensorEvent

data class TrafficStatsEvent(
    override val eventName: String = "TrafficStats",
    override val timestamp: Long,
    val receivedBytes: Long,
    val sentBytes: Long
) : SensorEvent
