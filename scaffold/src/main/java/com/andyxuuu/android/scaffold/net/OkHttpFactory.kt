package com.andyxuuu.android.scaffold.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 *  author : Andy Xuuu
 *  date : 11/24/20
 *  description :
 */
object OkHttpFactory {

    class Builder {
        val builder = OkHttpClient.Builder()

        fun setInterceptor(interceptor: List<Interceptor>?): Builder {
            val builder = OkHttpClient.Builder()
            interceptor?.let {
                it.forEach { i ->
                    builder.addInterceptor(i)
                }
            }
            return this
        }

        fun setTime(
            connectTime: Long,
            readTime: Long,
            writeTime: Long,
            failureRetry: Boolean
        ): Builder {
            builder.connectTimeout(connectTime, TimeUnit.SECONDS)
                .readTimeout(readTime, TimeUnit.SECONDS)
                .writeTimeout(writeTime, TimeUnit.SECONDS)
                .retryOnConnectionFailure(failureRetry)
            return this
        }

        fun build(): OkHttpClient {
            return builder.build()
        }
    }
}