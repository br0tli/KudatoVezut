package io.brotli.viper

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var dpm: DevicePolicyManager

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestAdminDevice()
        dpm = getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager

        btn_wipe.setOnClickListener {
            dpm.wipeData(0)
        }

    }

    private fun requestAdminDevice() {
        val deviceAdminSample = ComponentName(this, DeviceAdminSample::class.java)

        val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
            putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdminSample)
            putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "")
        }
        startActivityForResult(intent, 1234)
    }


}