package com.example.graphql.domain

import androidx.compose.runtime.Immutable

@Immutable
data class CountryListItem(
    val name: String,
    val code: String,
    val emoji: String
) {
    val uniqueId = name + code
}
