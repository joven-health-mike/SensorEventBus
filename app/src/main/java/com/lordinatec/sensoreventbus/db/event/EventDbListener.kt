package com.lordinatec.sensoreventbus.db.event

import com.lordinatec.sensoreventbus.analytics.event.AnalyticsEvent

class EventDbListener(private val db: EventDatabase) {
    fun onEvent(event: AnalyticsEvent) {
        db.insert(event)
    }
}