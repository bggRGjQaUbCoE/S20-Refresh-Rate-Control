package com.example.s20.refresh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShortCutsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_short_cuts)

        when (intent.data.toString()) {
            "96" -> set96HZ(this)
            "120" -> set120HZ(this)
        }

        finish()

    }

}