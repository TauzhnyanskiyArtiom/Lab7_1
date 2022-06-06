package ua.opu.lab

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import ua.opu.lab.receiver.AirplaneModeReceiver
import ua.opu.lab.receiver.CameraButtonReceiver
import ua.opu.lab.receiver.BatteryStateReceiver


class MainActivity : AppCompatActivity() {

    private val batteryStateReceiver = BatteryStateReceiver(supportFragmentManager)
    private val cameraButtonReceiver = CameraButtonReceiver(supportFragmentManager)
    private val airplaneModeReceiver = AirplaneModeReceiver(supportFragmentManager)

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            Log.d(MainActivity::class.simpleName, "Permission result: $it")
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val batteryStateFilter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        val cameraButtonFilter = IntentFilter(Intent.ACTION_CAMERA_BUTTON)
        val airplaneModeFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        registerReceiver(batteryStateReceiver, batteryStateFilter)
        registerReceiver(cameraButtonReceiver, cameraButtonFilter)
        registerReceiver(airplaneModeReceiver, airplaneModeFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(batteryStateReceiver)
        unregisterReceiver(cameraButtonReceiver)
        unregisterReceiver(airplaneModeReceiver)
    }

    override fun onResume() {
        super.onResume()
        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
    }
}