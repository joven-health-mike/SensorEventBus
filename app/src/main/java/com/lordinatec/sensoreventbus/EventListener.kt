package com.lordinatec.sensoreventbus

fun interface EventListener {
    fun onEvent(event: SensorEvent)
}