package com.example.graphql.countryList

import com.example.graphql.domain.CountryListItem

sealed class CountryListState {
    object Loading : CountryListState()
    data class Content(val items: List<CountryListItem>) : CountryListState()
    data class Error(val message: String) : CountryListState()
}