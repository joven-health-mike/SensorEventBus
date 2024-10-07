package com.lordinatec.sensoreventbus.analytics

import com.lordinatec.sensoreventbus.sensor.event.SensorEventBus

object AnalyticsManager {
    suspend fun listenForEvents(bus: SensorEventBus, factory: AnalyticsEventFactory) {
        bus.sensorEventFlow.collect{ event ->
            val analyticsEvent = factory.create(event)
            AnalyticsRepository.sendEvent(analyticsEvent)
        }
    }
}
