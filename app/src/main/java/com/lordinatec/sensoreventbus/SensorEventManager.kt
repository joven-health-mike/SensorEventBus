package com.lordinatec.sensoreventbus

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

object SensorEventManager {
    // SharedFlow that emits SensorEvents to subscribers
    private val _sensorEventFlow = MutableSharedFlow<SensorEvent>(replay = 0)
    val sensorEventFlow: SharedFlow<SensorEvent> = _sensorEventFlow

    // Function to publish events
    suspend fun publishEvent(event: SensorEvent) {
        _sensorEventFlow.emit(event)
    }
}