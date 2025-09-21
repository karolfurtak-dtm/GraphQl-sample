package com.example.graphql.domain

import androidx.compose.runtime.Stable

@Stable
data class CountryListItem(
    val name: String,
    val code: String,
    val emoji: String
)
