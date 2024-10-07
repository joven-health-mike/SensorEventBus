package com.lordinatec.sensoreventbus.sensor.event

interface SensorEvent {
    val eventName: String
    val timestamp: Long
}
