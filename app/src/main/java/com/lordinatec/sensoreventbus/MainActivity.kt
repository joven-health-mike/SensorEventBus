package com.lordinatec.sensoreventbus

import android.content.Intent
import android.content.IntentFilter
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
import com.lordinatec.sensoreventbus.ui.theme.SensorEventBusTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val eventBus = SensorEventFlow()
    private val airplaneModeReceiver =
        AirplaneModeReceiver(scope = lifecycleScope, eventBus = eventBus)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(airplaneModeReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        enableEdgeToEdge()
        setContent {
            SensorEventBusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Modifier.padding(innerPadding)
                    LaunchedEffect(Unit) {
                        lifecycleScope.launch {
                            eventBus.subscribe(eventListener).listen()
                        }
                    }
                }
            }
        }
    }

    private val eventListener = EventListener { event ->
        when (event) {
            SensorEvent.AirplaneModeOnEvent -> {
                println("Airplane Mode On Event")
            }

            SensorEvent.AirplaneModeOffEvent -> {
                println("Airplane Mode Off Event")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
    }
}
