package com.lordinatec.sensoreventbus

interface SensorEvent {
    object AirplaneModeOnEvent : SensorEvent
    object AirplaneModeOffEvent : SensorEvent
}