package com.example.graphql.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object CountryListScreen: NavKey

@Serializable
data class CountryDetailScreen(val code: CountryId): NavKey {

    @JvmInline
    @Serializable
    value class CountryId(val code: Int)
}