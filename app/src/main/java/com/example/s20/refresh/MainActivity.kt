package com.example.s20.refresh

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.s20.refresh.databinding.ActivityMainBinding
import com.google.android.material.color.DynamicColors
import com.google.android.material.elevation.SurfaceColors


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DynamicColors.applyToActivityIfAvailable(this)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rate96.setOnClickListener(this)
        binding.rate120.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.rate_96 -> set96HZ(this)

            R.id.rate_120 -> set120HZ(this)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        window.navigationBarColor = SurfaceColors.SURFACE_0.getColor(this)
    }

}