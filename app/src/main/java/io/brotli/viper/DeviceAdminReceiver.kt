package io.brotli.viper

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import android.os.UserHandle

class DeviceAdminSample : DeviceAdminReceiver() {

    override fun onEnabled(context: Context, intent: Intent) {
    }

    override fun onDisableRequested(context: Context, intent: Intent): CharSequence? {
        return null
    }

    override fun onDisabled(context: Context, intent: Intent) {
    }

    override fun onPasswordChanged(context: Context, intent: Intent, userHandle: UserHandle) {
    }
}
