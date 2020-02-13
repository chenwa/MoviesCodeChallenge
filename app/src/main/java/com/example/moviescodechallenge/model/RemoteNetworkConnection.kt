package com.example.moviescodechallenge.model

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RemoteNetworkConnection{
/*
    // api.openweathermap.org/data/2.5/forecast?
    // zip=94040,us
    // &apikey=123123123
    //// api.openweathermap.org/data/users/{id}/name

    @GET("forecast")
    fun kdkdkd(@Path("id")userId: String)
    fun getWeather(@Query("zip")zipCode: String,
                   @Query("apikey")apiKeyValue: String)

    Network.initiRetrofit.getWeather(
        tvZipValue.text,
    resources.getString(R.string.api)
    ).enqueue(////)
*/

    @GET("movies")
    fun getAllMovies() : Call<PokoMovieList>

    companion object{
        val baseUrl = "https://movies-sample.herokuapp.com/api/"
        fun initRetrofit(): RemoteNetworkConnection{
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RemoteNetworkConnection::class.java)
        }


        fun initRetrofit2(): RemoteNetworkConnection =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RemoteNetworkConnection::class.java)

        // Functions that evaluates if a Network call needs to happen
        fun checkCacheAge(context: Context){
            // true means read from Room
            // false means save and read from Room
            val maxSize: Long  = 1 * 1024 * 1024
            val cache = Cache(context.cacheDir,
                maxSize)
            val client: OkHttpClient =
                OkHttpClient.Builder()
                    .cache(cache)
                    .addInterceptor{
                        var request = it.request()
                        request.newBuilder()
                            .header("Cache-Control",
                                "public, max-age=" + 60 * 10)
                            .build()
                        it.proceed(request)
                    }.build()
        }
    }
}