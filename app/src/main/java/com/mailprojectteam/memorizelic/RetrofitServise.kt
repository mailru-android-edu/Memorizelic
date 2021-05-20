package com.mailprojectteam.memorizelic.ui

import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @Headers(
        *arrayOf(
            "content-type: application/x-www-form-urlencoded",
            "accept-encoding: application/gzip",
            "x-rapidapi-key: 09b7bf987emshf956815a19e422fp184e3djsn3d317e876483",
            "x-rapidapi-host: google-translate1.p.rapidapi.com"
        )
    )
    @FormUrlEncoded
    @POST("language/translate/")
    open fun translateWord(
        @Field("word") first: String?
    ): Call<String?>?
    fun getTranslate(): Call<String>
}