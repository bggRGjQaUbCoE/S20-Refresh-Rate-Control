package com.example.s20.refresh

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

private const val MIN_REFRESH_RATE = "min_refresh_rate"
private const val PEAK_REFRESH_RATE = "peak_refresh_rate"

fun set96HZ(context: Context) {
    setRefreshRate(context, MIN_REFRESH_RATE, "96.0")
    setRefreshRate(context, PEAK_REFRESH_RATE, "96.0")
}

fun set120HZ(context: Context) {
    setRefreshRate(context, MIN_REFRESH_RATE, "120.0")
    setRefreshRate(context, PEAK_REFRESH_RATE, "120.0")
}

fun setRefreshRate(context: Context, key: String, value: String) {
    runCatching {
        val contentValues = ContentValues(2).apply {
            put("name", key)
            put("value", value)
        }
        context.contentResolver.insert(Uri.parse("content://settings/system"), contentValues)
        Toast.makeText(context, "Applied", Toast.LENGTH_SHORT).show()
    }.onFailure {
        if (context is MainActivity) {
            MaterialAlertDialogBuilder(context)
                .setTitle("Failed to setConfig")
                .setMessage(it.message)
                .setPositiveButton(android.R.string.ok, null)
                .setNegativeButton("Log") { _, _ ->
                    MaterialAlertDialogBuilder(context)
                        .setTitle("Log")
                        .setMessage(it.stackTraceToString())
                        .setPositiveButton(android.R.string.ok, null)
                        .show()
                }
                .show()
        } else {
            Toast.makeText(context, "Failed to setConfig", Toast.LENGTH_SHORT).show()
        }
    }
}