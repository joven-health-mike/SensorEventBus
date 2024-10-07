package com.lordinatec.sensoreventbus.android

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class MyApplication : Application() {
    // Application-wide CoroutineScope tied to the application's lifecycle
    val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
}
