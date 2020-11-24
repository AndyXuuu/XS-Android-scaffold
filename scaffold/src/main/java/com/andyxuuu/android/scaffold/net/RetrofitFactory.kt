package com.andyxuuu.android.scaffold.net

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *  author : Andy Xuuu
 *  date : 11/24/20
 *  description :
 */
object RetrofitFactory {

    class Builder {
        private val retrofitBuilder = Retrofit.Builder()

        fun setHost(host: String): Builder {
            retrofitBuilder.baseUrl(host)
            return this
        }

        fun setOkHttp(client: OkHttpClient): Builder {
            retrofitBuilder.client(client)
            return this
        }

        fun setConverter(converter: Converter.Factory): Builder {
            retrofitBuilder.addConverterFactory(converter)
            return this
        }

        fun setAdapter(callAdapter: CallAdapter.Factory): Builder {
            retrofitBuilder.addCallAdapterFactory(callAdapter)
            return this
        }

        fun build(): Retrofit {
            return retrofitBuilder.build()
        }
    }

    /**
     * moshi 对null值敏感，需要严格要求数据结构对null的控制
     */
    fun getMoshiRetrofit(host: String, interceptor: List<Interceptor>?): Retrofit {
        return Builder().setHost(host)
            .setOkHttp(
                OkHttpFactory.Builder().setInterceptor(interceptor).build()
            ).setConverter(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            ).build()
    }

    fun getGsonRetrofit(host: String, interceptor: List<Interceptor>?): Retrofit {
        return Builder().setHost(host)
            .setOkHttp(
                OkHttpFactory.Builder().setInterceptor(interceptor).build()
            ).setConverter(
                GsonConverterFactory.create()
            ).build()
    }
}