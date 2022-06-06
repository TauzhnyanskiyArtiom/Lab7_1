package ua.opu.lab.dialog

import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AirplaneModeDialog(private val state: Boolean) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Airplane mode ")
            .setMessage(if (state) "Airplane mode is ON" else "Airplane mode is OFF")
            .setPositiveButton("OK") { _, _ ->
                this.dismiss()
            }
            .create()

    }

}


