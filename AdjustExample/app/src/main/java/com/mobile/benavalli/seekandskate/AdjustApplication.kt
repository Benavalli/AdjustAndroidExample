package com.mobile.benavalli.seekandskate

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.adjust.sdk.LogLevel

class AdjustApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val config =
                AdjustConfig(this, "adjust_token", AdjustConfig.ENVIRONMENT_SANDBOX)
        config.setLogLevel(LogLevel.VERBOSE)
        Adjust.onCreate(config)

        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(p0: Activity?) {
                Adjust.onPause()
            }

            override fun onActivityResumed(p0: Activity?) {
                Adjust.onResume()
            }

            override fun onActivityStarted(p0: Activity?) {}

            override fun onActivityDestroyed(p0: Activity?) {}

            override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {}

            override fun onActivityStopped(p0: Activity?) {}

            override fun onActivityCreated(p0: Activity?, p1: Bundle?) {}
        })
    }
}