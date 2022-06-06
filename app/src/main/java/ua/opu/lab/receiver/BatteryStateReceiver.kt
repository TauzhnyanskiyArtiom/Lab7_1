package ua.opu.lab.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import ua.opu.lab.dialog.BatteryStateDialog

class BatteryStateReceiver(private val fragmentManager: FragmentManager) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BATTERY_LOW) {
            val dialog = BatteryStateDialog()
            dialog.show(fragmentManager, "BatteryStateDialog")
        }
    }

}