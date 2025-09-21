package com.example.graphql.countryDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphql.domain.repo.CountryRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel(assistedFactory = CountryDetailViewModel.Factory::class)
class CountryDetailViewModel @AssistedInject constructor(
    @Assisted val code: String,
    private val repository: CountryRepository
) : ViewModel() {

    val state: StateFlow<CountryDetailState> = flow {
        emit(CountryDetailState.Loading)

        try {
            emit(CountryDetailState.Content(repository.getCountry(code = code)))
        } catch (e: Exception) {
            emit(CountryDetailState.Error(e.message.orEmpty()))
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = CountryDetailState.Loading
    )

    @AssistedFactory
    interface Factory {
        fun create(code: String): CountryDetailViewModel
    }
}