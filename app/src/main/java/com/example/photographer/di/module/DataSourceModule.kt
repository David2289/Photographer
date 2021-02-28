package com.example.photographer.di.module

import com.example.photographer.BuildConfig
import com.example.photographer.business.apirest.APIService
import com.example.photographer.business.datasource.local.UsersLocalDataSource
import com.example.photographer.business.datasource.remote.UsersRemoteDataSource
import com.example.photographer.business.interceptor.BasicAuthInterceptor
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class DataSourceModule {

    @Provides
    fun provideRetrofit(): Retrofit {

        val httpLoggingInterceptor = HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(BasicAuthInterceptor(BuildConfig.API_AUTH_USERNAME, BuildConfig.API_AUTH_PASSWORD))
                .addInterceptor(httpLoggingInterceptor) //httpLoggingInterceptor allows to log json body.
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Provides
    fun provideUsersRemoteDataSource(apiService: APIService): UsersRemoteDataSource {
        return UsersRemoteDataSource(apiService)
    }

    @Provides
    fun provideUsersLocalDataSource(): UsersLocalDataSource {
        return UsersLocalDataSource()
    }

}