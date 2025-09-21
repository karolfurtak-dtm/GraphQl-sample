package com.example.graphql.countryDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphql.domain.CountryDetail
import com.example.graphql.domain.repo.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val repository: CountryRepository
) : ViewModel() {

    val data: StateFlow<CountryDetail?> = flow {
        emit(repository.getCountry(code = "PL"))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = null
    )
}