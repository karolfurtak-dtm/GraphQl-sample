package com.example.graphql.api

import com.apollographql.apollo3.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery
import javax.inject.Inject

interface CountryService {
    suspend fun getCountries(): List<CountriesQuery.Country>?
    suspend fun getCountry(id: String): CountryQuery.Country?
}

class CountryServiceImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : CountryService {

    override suspend fun getCountries(): List<CountriesQuery.Country>? {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data?.countries
    }

    override suspend fun getCountry(id: String): CountryQuery.Country? {
        return apolloClient
            .query(CountryQuery(code = id))
            .execute()
            .data?.country
    }
}