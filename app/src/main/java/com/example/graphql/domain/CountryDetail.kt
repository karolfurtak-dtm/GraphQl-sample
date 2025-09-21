package com.example.graphql.domain

import androidx.compose.runtime.Stable

@Stable
data class CountryDetail(
    val name: String,
    val capital: String?,
    val code: String,
    val emoji: String,
    val languages: List<Language>,
) {
    @JvmInline
    value class Language(val name: String)
}