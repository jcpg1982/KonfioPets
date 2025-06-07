package pe.com.master.machines.konfiopets.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LaunchApp : Application() {

    private val TAG = LaunchApp::class.java.simpleName

    override fun onCreate() {
        super.onCreate()

    }
}