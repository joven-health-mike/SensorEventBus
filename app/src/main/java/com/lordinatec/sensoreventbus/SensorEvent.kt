package com.lordinatec.sensoreventbus

/**
 * Represents a sensor event.
 */
interface SensorEvent {
    /**
     * Represents the event when airplane mode is turned on.
     */
    object AirplaneModeOnEvent : SensorEvent

    /**
     * Represents the event when airplane mode is turned off.
     */
    object AirplaneModeOffEvent : SensorEvent
}