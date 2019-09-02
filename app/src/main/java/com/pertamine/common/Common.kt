package com.pertamine.common

import com.pertamine.remote.PertamineInterface
import com.pertamine.remote.RetrofitClient

object Common {
    val BASE_URL = "http://6eed8aca.ap.ngrok.io/api/"

    val api: PertamineInterface
        get() = RetrofitClient.getClient(BASE_URL).create(PertamineInterface::class.java)

}