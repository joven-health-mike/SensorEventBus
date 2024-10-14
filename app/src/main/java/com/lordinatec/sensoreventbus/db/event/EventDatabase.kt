package com.lordinatec.sensoreventbus.db.event

import com.lordinatec.sensoreventbus.analytics.event.AnalyticsEvent
import com.lordinatec.sensoreventbus.db.Database

interface EventDatabase : Database<AnalyticsEvent> {
    fun selectByType(type: String): List<AnalyticsEvent>
}

class EventDatabaseImpl : EventDatabase {
    // TODO: Implement as Room database
    private val events = mutableListOf<AnalyticsEvent>()

    override fun insert(item: AnalyticsEvent) {
        events.add(item)
    }

    override fun update(item: AnalyticsEvent) {
        val index = events.indexOfFirst { it.id == item.id }
        if (index != -1) {
            events[index] = item
        }
    }

    override fun delete(item: AnalyticsEvent) {
        events.remove(item)
    }

    override fun selectAll(): List<AnalyticsEvent> {
        return events.toList()
    }

    override fun selectById(id: Long): AnalyticsEvent? {
        return events.find { it.id == id }
    }

    override fun selectByQuery(query: String): List<AnalyticsEvent> {
        return events.filter { it.eventName.contains(query, ignoreCase = true) }
    }

    override fun deleteAll() {
        events.clear()
    }

    override fun selectByType(type: String): List<AnalyticsEvent> {
        return events.filter { it.eventName == type }
    }
}