package com.lordinatec.sensoreventbus

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * SensorEventFlow is an implementation of SensorEventBus that uses a SharedFlow to publish events.
 *
 * @constructor creates a SensorEventFlow
 */
class SensorEventFlow : SensorEventBus {
    private val _sensorEvents = MutableSharedFlow<SensorEvent>()

    /**
     * A SharedFlow of SensorEvents.
     */
    val sensorEvents = _sensorEvents.asSharedFlow()

    private val subscribers = mutableListOf<EventListener>()

    override suspend fun publish(event: SensorEvent) {
        _sensorEvents.emit(event)
    }

    override suspend fun subscribe(listener: EventListener): SensorEventBus {
        subscribers.add(listener)
        return this
    }

    override suspend fun listen() {
        sensorEvents.collect { event ->
            subscribers.forEach { it.onEvent(event) }
        }
    }
}