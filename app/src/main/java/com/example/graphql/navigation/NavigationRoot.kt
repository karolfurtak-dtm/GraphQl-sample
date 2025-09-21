package com.example.graphql.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.graphql.countryDetail.CountryDetailScreen
import com.example.graphql.countryList.CountryListScreen

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(CountryListScreen)
    NavDisplay(
        modifier = modifier.fillMaxSize(),
        backStack = backStack,
        entryProvider = { screen ->
            when (screen) {
                is CountryListScreen -> {
                    NavEntry(key = screen) {
                        CountryListScreen()
                    }
                }

                is CountryDetailScreen -> {
                    NavEntry(key = screen) {
                        CountryDetailScreen()
                    }
                }

                else -> throw IllegalArgumentException("Unknown screen $screen")
            }
        }
    )
}