package com.pertamine.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pertamine.R

class DetailStatus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_status)
    }

    fun back(v: View?){
        onBackPressed()
    }
}
