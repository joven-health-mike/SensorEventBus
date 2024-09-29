package com.lordinatec.sensoreventbus

interface SensorEventBus {
    suspend fun publish(event: SensorEvent)
    suspend fun subscribe(listener: EventListener): SensorEventBus
    suspend fun listen()
}