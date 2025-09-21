package com.example.graphql.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.example.graphql.countryDetail.CountryDetailScreenUi
import com.example.graphql.countryDetail.CountryDetailViewModel
import com.example.graphql.countryList.CountryListScreenUi
import com.example.graphql.countryList.CountryListViewModel

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(CountryListScreen)
    NavDisplay(
        modifier = modifier.fillMaxSize(),
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = { screen ->
            when (screen) {
                is CountryListScreen -> {
                    NavEntry(key = screen) {
                        val viewModel: CountryListViewModel = hiltViewModel()
                        val state = viewModel.state.collectAsStateWithLifecycle().value

                        CountryListScreenUi(
                            state = state,
                            onItemClick = {
                                backStack.add(CountryDetailScreen(countryCode = it))
                            }
                        )
                    }
                }

                is CountryDetailScreen -> {
                    NavEntry(key = screen) {
                        val viewModel = hiltViewModel<CountryDetailViewModel, CountryDetailViewModel.Factory>(
                            creationCallback = { factory -> factory.create(code = screen.countryCode.id) }
                        )
                        val state = viewModel.state.collectAsStateWithLifecycle().value

                        CountryDetailScreenUi(state = state)
                    }
                }

                else -> throw IllegalArgumentException("Unknown screen $screen")
            }
        }
    )
}