package com.example.photographer.business.interceptor

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicAuthInterceptor constructor(username: String, password: String): Interceptor {

    val credential = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authRequest: Request = request.newBuilder()
                .header("Authorization", credential)
                .header("Accept", "application/json")
                .build()
        return chain.proceed(authRequest)
    }
}