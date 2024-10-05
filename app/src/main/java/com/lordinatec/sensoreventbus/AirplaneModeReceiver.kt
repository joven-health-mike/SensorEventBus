package com.lordinatec.sensoreventbus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AirplaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeOn = intent?.getBooleanExtra("state", false) ?: return
        GlobalScope.launch {
            SensorManager.onAirplaneModeChanged(isAirplaneModeOn)
            AnalyticsManager.onAirplaneModeChanged(isAirplaneModeOn)
        }
    }
}