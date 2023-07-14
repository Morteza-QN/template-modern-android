package me.morteza.modernlayer.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /* @AuthInterceptorOkHttpClient
     @Provides
     fun provideAuthInterceptorOkHttpClient(
       authInterceptor: AuthInterceptor
     ): OkHttpClient {
         return OkHttpClient.Builder()
                  .addInterceptor(authInterceptor)
                  .build()
     }

     @OtherInterceptorOkHttpClient
     @Provides
     fun provideOtherInterceptorOkHttpClient(
       otherInterceptor: OtherInterceptor
     ): OkHttpClient {
         return OkHttpClient.Builder()
                  .addInterceptor(otherInterceptor)
                  .build()
     }*/
}

/*
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherInterceptorOkHttpClient
* */