package com.example.coroutineexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutineexample.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private val tag : String = "SOHAIB"
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(tag, Thread.currentThread().name)

        binding.imgNext.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnCount.setOnClickListener {
            Log.d(tag, Thread.currentThread().name)
            binding.txtShow.text = "${binding.txtShow.text.toString().toInt() + 1}"
        }

        binding.btnLongRun.setOnClickListener {
            Log.d(tag, Thread.currentThread().name)
            Thread.sleep(5000)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}