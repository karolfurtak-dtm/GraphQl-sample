package com.example.graphql.countryList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CountryListScreenUi(
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit
) {
    val viewModel: CountryListViewModel = viewModel()

    val list = viewModel.countries.collectAsStateWithLifecycle().value

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = list,
            key = { it.code }
        ) { country ->
            Text(
                text = country.name + country.code + country.emoji,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clickable { onItemClick(country.code.toInt()) }
            )
        }
    }
}