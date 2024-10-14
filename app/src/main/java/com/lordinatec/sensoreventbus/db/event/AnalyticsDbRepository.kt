package com.lordinatec.sensoreventbus.db.event

import com.lordinatec.sensoreventbus.analytics.event.AnalyticsEvent

object AnalyticsDbRepository {
    private val database = EventDatabaseImpl()

    fun saveEvent(event: AnalyticsEvent) {
        database.insert(event)
    }

    fun getEvents(): List<AnalyticsEvent> {
        return database.selectAll()
    }
}
