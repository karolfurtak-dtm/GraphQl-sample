package com.example.graphql.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object CountryListScreen: NavKey

@Serializable
data class CountryDetailScreen(val countryCode: CountryCode): NavKey {

    @JvmInline
    @Serializable
    value class CountryCode(val id: String)
}