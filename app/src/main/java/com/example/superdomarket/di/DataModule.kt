package com.example.superdomarket.di

import com.example.superdomarket.data.ProductsProvider
import com.example.superdomarket.data.ProductsProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProviderWsModule {

    @Singleton
    @Provides
    fun provideProductsWs(): ProductsProvider = ProductsProviderImpl()
}