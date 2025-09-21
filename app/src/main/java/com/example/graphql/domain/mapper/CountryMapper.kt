package com.example.graphql.domain.mapper

import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphql.domain.CountryDetail
import com.example.graphql.domain.CountryListItem

fun CountriesQuery.Country.toCountryListItem(): CountryListItem {
    return CountryListItem(
        code = code,
        name = name,
        emoji = emoji
    )
}

fun CountryQuery.Country.toCountryDetail(): CountryDetail {
    return CountryDetail(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital,
        languages = languages.map { CountryDetail.Language(it.name) }
    )
}