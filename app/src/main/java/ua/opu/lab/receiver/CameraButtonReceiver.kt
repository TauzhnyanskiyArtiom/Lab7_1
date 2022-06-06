package ua.opu.lab.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import ua.opu.lab.dialog.CameraButtonDialog

class CameraButtonReceiver(private val fragmentManager: FragmentManager) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_CAMERA_BUTTON) {
            val dialog = CameraButtonDialog()
            dialog.show(fragmentManager, "CameraButtonClickDialog")
        }
    }
}