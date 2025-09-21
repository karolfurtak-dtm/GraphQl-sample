package com.example.graphql.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.graphql.countryDetail.CountryDetailScreenUi
import com.example.graphql.countryList.CountryListScreenUi

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
                        CountryListScreenUi(
                            onItemClick = {
                                backStack.add(
                                    CountryDetailScreen(countryCode = CountryDetailScreen.CountryCode(id = it))
                                )
                            }
                        )
                    }
                }

                is CountryDetailScreen -> {
                    NavEntry(key = screen) {
                        CountryDetailScreenUi(id = screen.countryCode)
                    }
                }

                else -> throw IllegalArgumentException("Unknown screen $screen")
            }
        }
    )
}