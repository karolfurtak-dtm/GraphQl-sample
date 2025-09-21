package com.example.graphql.countryList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.graphql.domain.CountryListItem

@Composable
fun CountryListScreenUi(
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit,
) {
    val viewModel: CountryListViewModel = hiltViewModel()
    val list = viewModel.items.collectAsStateWithLifecycle().value

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = list,
            key = { it.uniqueId }
        ) { item ->
            CountryItem(
                country = item,
                onClick = { onItemClick(it.code) }
            )
        }
    }
}

@Composable
private fun CountryItem(
    country: CountryListItem,
    onClick: (CountryListItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(country) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = country.emoji,
            fontSize = 24.sp,
            modifier = Modifier.padding(end = 12.dp)
        )

        Column {
            Text(
                text = country.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = country.code,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}
