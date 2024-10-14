package com.lordinatec.sensoreventbus.db

interface Database<T> {
    fun insert(item: T)
    fun update(item: T)
    fun delete(item: T)
    fun selectAll(): List<T>
    fun selectById(id: Long): T?
    fun selectByQuery(query: String): List<T>
    fun deleteAll()
}