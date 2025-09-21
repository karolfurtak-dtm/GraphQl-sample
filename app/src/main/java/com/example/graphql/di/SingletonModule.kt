package com.example.graphql.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphql.api.CountryService
import com.example.graphql.api.CountryServiceImpl
import com.example.graphql.domain.repo.CountryRepository
import com.example.graphql.domain.repo.CountryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryService(apolloClient: ApolloClient): CountryService {
        return CountryServiceImpl(apolloClient)
    }

    @Provides
    @Singleton
    fun provideCountryRepository(countryService: CountryService): CountryRepository {
        return CountryRepositoryImpl(countryService)
    }
}