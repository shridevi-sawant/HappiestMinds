package com.happiestminds.uidialogdemo

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var dlg : Dialog? = null

        // retrieve bundle
        val message = arguments?.getString("msg")
        // create dialog here

        context?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Confirmation")
            builder.setMessage(message)
            builder.setPositiveButton("YES"){ dialog, i ->
                // executed button clicking
                activity?.finish()
            }

            builder.setNegativeButton("NO") { dialog, i ->
                dialog.cancel()
            }

            builder.setNeutralButton("Cancel") { dialg, i ->
                dialg.cancel()

            }



            dlg = builder.create()
        }

        return dlg!!
    }

}