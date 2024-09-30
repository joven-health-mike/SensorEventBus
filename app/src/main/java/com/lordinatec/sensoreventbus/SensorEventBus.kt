package com.lordinatec.sensoreventbus

/**
 * SensorEventBus is a simple event bus that allows for the publishing and subscribing to events.
 */
interface SensorEventBus {
    /**
     * Publishes an event to the event bus.
     */
    suspend fun publish(event: SensorEvent)

    /**
     * Subscribes to events on the event bus.
     */
    suspend fun subscribe(listener: EventListener): SensorEventBus

    /**
     * Listens for events on the event bus.
     */
    suspend fun listen()
}