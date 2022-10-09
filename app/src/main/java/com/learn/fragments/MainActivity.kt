package com.learn.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learn.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        //initial fragment
        supportFragmentManager.beginTransaction().apply {
            this.replace(R.id.fragmentContainer, firstFragment)
            this.commit()
        }

        binding.frChangeBtn1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                this.replace(R.id.fragmentContainer, firstFragment)
                addToBackStack("FirstFragment BackStack")
                this.commit()
            }
        }

        binding.frChangeBtn2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                this.replace(R.id.fragmentContainer, secondFragment)
                addToBackStack("SecondFragment BackStack")
                this.commit()
            }
        }
    }
}