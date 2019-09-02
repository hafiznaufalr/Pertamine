package com.pertamine.activity

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pertamine.R
import com.pertamine.common.Common
import com.pertamine.model.User
import com.pertamine.remote.PertamineInterface
import kotlinx.android.synthetic.main.activity_login.*

class   LoginActivity : AppCompatActivity() {
    internal lateinit var mService: PertamineInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setTypeFace()
        mService = Common.api

        tv_regis.setOnClickListener {
            val a = Intent(this, RegisterActivity::class.java)
            startActivity(a)
        }

        btn_login.setOnClickListener {

            when {
                et_email.text.toString().trim().isEmpty() -> {
                    Toast.makeText(applicationContext, "Email Harus Diisi!", Toast.LENGTH_SHORT).show()
                    et_email.error = "err"
                }
                et_password.text.toString().trim().isEmpty() -> {
                    Toast.makeText(applicationContext, "Password Harus Diisi!", Toast.LENGTH_SHORT).show()
                    et_email.error = "err"
                }
                else -> authenticateUser(et_email.text.toString(),et_password.text.toString())
            }
        }

    }

    private fun setTypeFace() {
        val PBold = Typeface.createFromAsset(assets, "fonts/Poppins-Bold.otf")
        val PRegular = Typeface.createFromAsset(assets, "fonts/Poppins-Regular.otf")

        tv_welcome.typeface = PBold
        tv_message.typeface = PRegular
        et_email.typeface = PRegular
        et_password.typeface = PRegular
        btn_login.typeface = PBold
        tv_ask.typeface = PRegular
        tv_regis.typeface = PRegular

    }

    private fun authenticateUser(email: String, password: String) {
        mService.loginUser(email, password)
            .enqueue(object: retrofit2.Callback<User> {
                override fun onFailure(call: retrofit2.Call<User>, t: Throwable) {
                    Toast.makeText(this@LoginActivity,"Mohon Periksa Koneksi Internet", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: retrofit2.Call<User>, response: retrofit2.Response<User>) {
                    if (response.body()!!.success) {
                        Toast.makeText(this@LoginActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                        val a = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(a)
                        finish()
                    }
                    else {
                        Toast.makeText(this@LoginActivity, "Login Gagal", Toast.LENGTH_SHORT).show()
                    }
                }
            } )

    }


}

