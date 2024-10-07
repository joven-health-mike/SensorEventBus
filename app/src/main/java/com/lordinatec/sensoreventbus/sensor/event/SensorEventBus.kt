package com.lordinatec.sensoreventbus.sensor.event

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object SensorEventBus {
    // SharedFlow that emits SensorEvents to subscribers
    private val _sensorEventFlow = MutableSharedFlow<SensorEvent>(replay = 0)
    val sensorEventFlow = _sensorEventFlow.asSharedFlow()

    // Function to publish events
    suspend fun publishEvent(event: SensorEvent) {
        _sensorEventFlow.emit(event)
    }
}
