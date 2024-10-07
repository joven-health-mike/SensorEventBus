package com.lordinatec.sensoreventbus.analytics

object AnalyticsRepository {
//    private val apiService = ApiClient.createService(AnalyticsApiService::class.java)

    fun sendEvent(event: AnalyticsEvent) {
        println("sending analytics event: $event")
//        apiService.sendAnalyticsEvent(event.toJson())
//            .enqueue(object : Callback<Void> {
//                override fun onResponse(call: Call<Void>, response: Response<Void>) {
//        Handle successful response
//                }
//
//                override fun onFailure(call: Call<Void>, t: Throwable) {
//        Handle failure (retry or log)
//                }
//            })
    }
}