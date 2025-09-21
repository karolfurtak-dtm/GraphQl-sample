package com.example.graphql.domain.repo

import com.example.graphql.api.CountryService
import com.example.graphql.domain.CountryDetail
import com.example.graphql.domain.CountryListItem
import com.example.graphql.domain.mapper.toCountryDetail
import com.example.graphql.domain.mapper.toCountryListItem
import javax.inject.Inject

interface CountryRepository {
    suspend fun getCountries(): List<CountryListItem>
    suspend fun getCountry(code: String): CountryDetail?
}

class CountryRepositoryImpl @Inject constructor(
    private val countryService: CountryService
) : CountryRepository {

    override suspend fun getCountries(): List<CountryListItem> {
        return countryService.getCountries()
            ?.map { it.toCountryListItem() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): CountryDetail? {
        return countryService.getCountry(id = code)
            ?.toCountryDetail()
    }
}