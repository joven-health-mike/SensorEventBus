package com.lordinatec.sensoreventbus.analytics

import com.lordinatec.sensoreventbus.analytics.event.AnalyticsEvent

object AnalyticsRepository {
    fun sendEvent(event: AnalyticsEvent) {
        println("sending analytics event: $event")
    }
}
