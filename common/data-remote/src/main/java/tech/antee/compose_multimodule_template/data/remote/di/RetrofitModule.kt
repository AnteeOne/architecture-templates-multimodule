package tech.antee.compose_multimodule_template.data.remote.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.antee.compose_multimodule_template.data.remote.api.NetworkApi
import tech.antee.compose_multimodule_template.data.remote.config.NetworkConfig
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun appNetworkApi(retrofit: Retrofit): NetworkApi = retrofit.create(NetworkApi::class.java)

    @Provides
    @Singleton
    fun retrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(NetworkConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}
