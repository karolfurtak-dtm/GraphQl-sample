package com.example.graphql.countryDetail

import com.example.graphql.domain.CountryDetail

sealed class CountryDetailState {
    object Loading : CountryDetailState()
    data class Content(val data: CountryDetail?) : CountryDetailState()
    data class Error(val message: String) : CountryDetailState()
}