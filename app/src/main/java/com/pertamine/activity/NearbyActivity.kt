package com.pertamine.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pertamine.R
import kotlinx.android.synthetic.main.activity_nearby.*
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper



class NearbyActivity : AppCompatActivity() {

    var cikini = "-6.195792, 106.840276"
    var gmap = "com.google.android.apps.maps"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Poppins-Regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
        setContentView(R.layout.activity_nearby)

        toko1.setOnClickListener {
            val uri = Uri.parse("google.navigation:q=$cikini");

            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage(gmap)

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                    Toast.LENGTH_LONG).show()

            }
        }
    }




    fun back(v: View?){
        onBackPressed()
    }
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}
