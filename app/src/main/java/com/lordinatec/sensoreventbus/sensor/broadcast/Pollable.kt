package com.lordinatec.sensoreventbus.sensor.broadcast

import android.content.Context

fun interface Pollable {
    fun poll(context: Context)
}
