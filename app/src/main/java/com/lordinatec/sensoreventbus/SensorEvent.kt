package com.lordinatec.sensoreventbus

interface SensorEvent {
    val eventName: String
    val timestamp: Long
}
