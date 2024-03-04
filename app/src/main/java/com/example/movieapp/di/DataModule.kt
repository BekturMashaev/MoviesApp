package com.example.movieapp.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.data_base.local.MoviesDAO
import com.example.movieapp.data.data_base.local.MoviesDatabase
import com.example.movieapp.data.data_base.remote.MoviesDataService
import com.example.movieapp.data.repository.DefaultGetMoviesDataRepository
import com.example.movieapp.data.utils.Constants.API_KEY
import com.example.movieapp.data.utils.Constants.BASE_URL
import com.example.movieapp.domain.repository.GetMoviesDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataModule {


    @Provides
    fun provideMovies(
        service: MoviesDataService,
        dao: MoviesDAO
    ): GetMoviesDataRepository {
        return DefaultGetMoviesDataRepository(
            service = service,
            dao = dao
        )
    }

        @Provides
        fun provideMoviesService(retrofit: Retrofit): MoviesDataService {
            return retrofit.create(MoviesDataService::class.java)
        }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(Interceptor { chain ->
                        val request = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", "Bearer $API_KEY")
                            .build()
                        return@Interceptor chain.proceed(request = request)
                    }).build()
            ).build()
    }
}