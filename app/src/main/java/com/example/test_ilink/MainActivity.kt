package com.example.test_ilink

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private  lateinit var  vm:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val duckButton = findViewById<Button>(R.id.buttonDuck)
        val catButton = findViewById<Button>(R.id.buttonCat)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.urlPicture.observe(this, Observer {
            if(it!="")
            {
                (catButton.layoutParams as ConstraintLayout.LayoutParams).bottomMargin =16
                (duckButton.layoutParams as ConstraintLayout.LayoutParams).bottomMargin =16
            }
            Log.d("Info",it)
            Picasso.get().load(it).into(imageView)

        })
        duckButton.setOnClickListener()
        {
            vm.duckLoad()
        }
        catButton.setOnClickListener()
        {
            vm.catLoad()
        }

    }
}