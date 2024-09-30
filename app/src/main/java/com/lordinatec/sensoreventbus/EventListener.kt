package com.lordinatec.sensoreventbus

/**
 * EventListener is a functional interface that listens for SensorEvents.
 */
fun interface EventListener {
    /**
     * onEvent is called when a SensorEvent is received.
     */
    fun onEvent(event: SensorEvent)
}