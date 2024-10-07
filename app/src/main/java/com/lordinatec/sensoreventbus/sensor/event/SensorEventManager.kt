package com.lordinatec.sensoreventbus.sensor.event

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.os.Looper
import com.lordinatec.sensoreventbus.sensor.AirplaneModeReceiver
import com.lordinatec.sensoreventbus.sensor.TrafficStatsReceiver
import com.lordinatec.sensoreventbus.sensor.broadcast.TrafficStatsPollable

object SensorEventManager {
    private var airplaneModeReceiver: AirplaneModeReceiver? = null
    private var trafficStatsReceiver: TrafficStatsReceiver? = null
    private val trafficStatsPollable = TrafficStatsPollable()
    private var isPollingTrafficStats = false
    private val trafficStatsHandler = Handler(Looper.getMainLooper())
    private var trafficStatsRunnable: Runnable? = null

    class TrafficStatsRunnable(private val context: Context) : Runnable {
        override fun run() {
            trafficStatsPollable.poll(context)
            // Schedule the next poll
            trafficStatsHandler.postDelayed(this, POLLING_INTERVAL)
        }
    }

    fun enableAirplaneModeTracking(context: Context) {
        if (airplaneModeReceiver == null) {
            airplaneModeReceiver = AirplaneModeReceiver(SensorEventBus, SensorEventFactory)
            val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            context.registerReceiver(airplaneModeReceiver, filter)
        }
    }

    fun disableAirplaneModeTracking(context: Context) {
        airplaneModeReceiver?.let {
            context.unregisterReceiver(it)
            airplaneModeReceiver = null
        }
    }

    fun enableTrafficStatsTracking(context: Context) {
        if (trafficStatsReceiver == null) {
            trafficStatsReceiver = TrafficStatsReceiver(SensorEventBus, SensorEventFactory)
            val filter = IntentFilter(TrafficStatsPollable.ACTION)
            context.registerReceiver(trafficStatsReceiver, filter, Context.RECEIVER_EXPORTED)
        }
    }

    fun disableTrafficStatsTracking(context: Context) {
        trafficStatsReceiver?.let {
            context.unregisterReceiver(it)
            trafficStatsReceiver = null
        }
    }

    fun enableTrafficStatsPolling(context: Context) {
        if (!isPollingTrafficStats) {
            isPollingTrafficStats = true
            trafficStatsRunnable = TrafficStatsRunnable(context).also {
                trafficStatsHandler.post(it)
            }
        }
    }

    fun disableTrafficStatsPolling() {
        if (isPollingTrafficStats) {
            isPollingTrafficStats = false
            trafficStatsRunnable?.let {
                trafficStatsHandler.removeCallbacks(it)
            }
        }
    }

    private const val POLLING_INTERVAL = 10_000L  // 10 seconds
}
