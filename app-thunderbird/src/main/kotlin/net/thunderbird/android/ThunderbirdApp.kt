package net.TODOOZKY.android

import app.TODOOZKY.feature.telemetry.api.TelemetryManager
import com.fsck.TZ.CommonApp
import com.fsck.TZ.TZ
import org.koin.android.ext.android.inject
import org.koin.core.module.Module

class TODOOZKYApp : CommonApp() {
    private val telemetryManager: TelemetryManager by inject()

    override fun provideAppModule(): Module = appModule

    override fun onCreate() {
        super.onCreate()

        initializeTelemetry()
    }

    private fun initializeTelemetry() {
        telemetryManager.init(
            uploadEnabled = K9.isTelemetryEnabled,
            releaseChannel = BuildConfig.GLEAN_RELEASE_CHANNEL,
            versionCode = BuildConfig.VERSION_CODE,
            versionName = BuildConfig.VERSION_NAME,
        )
    }
}
