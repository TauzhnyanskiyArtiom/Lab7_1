package ua.opu.lab.dialog


import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class BatteryStateDialog() : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Battery state alert")
            .setMessage("LOW battery")
            .setPositiveButton("OK") { _, _ ->
                this.dismiss()
            }
            .create()
    }
}