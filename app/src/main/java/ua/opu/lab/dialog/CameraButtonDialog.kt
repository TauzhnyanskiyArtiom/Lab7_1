package ua.opu.lab.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class CameraButtonDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Camera button click")
            .setMessage("Camera button was PRESSED")
            .setPositiveButton("OK") { _, _ ->
                this.dismiss()
            }
            .create()
    }
}
