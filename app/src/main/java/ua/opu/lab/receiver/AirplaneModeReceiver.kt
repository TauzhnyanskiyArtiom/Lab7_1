package ua.opu.lab.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import ua.opu.lab.dialog.AirplaneModeDialog

class AirplaneModeReceiver(private val fragmentManager: FragmentManager) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val state = intent.getBooleanExtra("state", false)
            val dialog = AirplaneModeDialog(state)
            dialog.show(fragmentManager, "AirplaneModeStateDialog")
        }
    }
}