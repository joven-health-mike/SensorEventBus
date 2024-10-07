package com.lordinatec.sensoreventbus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.lordinatec.sensoreventbus.sensor.event.AirplaneModeEvent
import com.lordinatec.sensoreventbus.sensor.event.SensorEventManager
import com.lordinatec.sensoreventbus.sensor.event.SensorEventBus
import com.lordinatec.sensoreventbus.sensor.event.TrafficStatsEvent
import com.lordinatec.sensoreventbus.ui.theme.SensorEventBusTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SensorEventBusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Modifier.padding(innerPadding)
                    LaunchedEffect(Unit) {
                        lifecycleScope.launch {
                            // start polling
                            SensorEventManager.enableTrafficStatsPolling(applicationContext)

                            // start tracking
                            SensorEventManager.enableAirplaneModeTracking(applicationContext)
                            SensorEventManager.enableTrafficStatsTracking(applicationContext)

                            // collect events
                            SensorEventBus.sensorEventFlow.collect { event ->
                                when (event) {
                                    is AirplaneModeEvent -> {
                                        println("Airplane mode is ${if (event.isEnabled) "enabled" else "disabled"} at ${event.timestamp}")
                                    }

                                    is TrafficStatsEvent -> {
                                        println("Received: ${event.receivedBytes} bytes, Sent: ${event.sentBytes} bytes at ${event.timestamp}")
                                    }

                                    else -> {
                                        println("Unknown event: ${event.eventName}")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
