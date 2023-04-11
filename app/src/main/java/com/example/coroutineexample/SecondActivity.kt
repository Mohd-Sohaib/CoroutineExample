package com.example.coroutineexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutineexample.databinding.ActivitySecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondActivity : AppCompatActivity() {

    private var _binding : ActivitySecondBinding? = null
    private val binding get() = _binding!!
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("SOHAIB2", Thread.currentThread().name)

        binding.btnCount.setOnClickListener {
            Log.d("SOHAIB2", Thread.currentThread().name)
            binding.txtShow.text = "${binding.txtShow.text.toString().toInt() + 1}"
        }

        binding.btnLongRun.setOnClickListener {
            MainScope().launch {
                Log.d("SOHAIB2", Thread.currentThread().name)
                withContext(Dispatchers.IO) {
                    Log.d("SOHAIB2", Thread.currentThread().name)
                    Thread.sleep(5000)
                }
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}