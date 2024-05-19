package com.example.s20.refresh

import android.graphics.drawable.Icon
import android.os.Build
import android.service.quicksettings.TileService
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
class ControllerTile120 : TileService() {

    override fun onClick() {
        super.onClick()
        set120HZ(this)
    }

    override fun onStartListening() {
        super.onStartListening()
        qsTile.apply {
            label = getString(R.string.set_120_hz)
            state = 2
            icon = Icon.createWithResource(this@ControllerTile120, R.drawable.outline_refresh_24)
            updateTile()
        }
    }

}