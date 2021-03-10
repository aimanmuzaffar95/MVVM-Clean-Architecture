package com.aiman.mvvmcleanarchitecture.utils

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.aiman.mvvmcleanarchitecture.R

object Utils {
    const val gone = View.GONE
    const val visible = View.VISIBLE
    const val invisible = View.INVISIBLE

    fun showAlertMessage(context: Context, message: String) {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(message)
        dialogBuilder.setCancelable(false)
        dialogBuilder.setPositiveButton(context.getString(R.string.ok)) { dialog, which -> }
        if (!(context as Activity).isFinishing) {
            dialogBuilder.create().show()
        }
    }
}