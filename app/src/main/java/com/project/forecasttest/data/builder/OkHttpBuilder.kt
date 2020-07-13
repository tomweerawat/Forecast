package com.project.forecasttest.data.builder

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkHttpBuilder {

    fun build(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY


        val headerAuthorizationInterceptor = Interceptor { chain ->
            var request = chain.request()
            val headers = request.headers.newBuilder()
                .add("Accept", "application/json")
                .add("Content-Type", "application/json")
//                .add("Authorization", authToken)
//                .add("user-key",": $token")
                .build()
            request = request.newBuilder().headers(headers).build()
            chain.proceed(request)
        }
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(headerAuthorizationInterceptor)
            .addNetworkInterceptor(headerAuthorizationInterceptor)
            .build()
    }
}