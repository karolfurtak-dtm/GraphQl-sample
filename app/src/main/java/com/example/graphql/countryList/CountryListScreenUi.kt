package com.example.graphql.countryList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graphql.domain.CountryListItem
import com.example.graphql.navigation.CountryDetailScreen
import com.example.graphql.ui.common.CenteredErrorIndicator
import com.example.graphql.ui.common.CenteredLoadingIndicator

@Composable
fun CountryListScreenUi(
    modifier: Modifier = Modifier,
    state: CountryListState,
    onItemClick: (CountryDetailScreen.CountryCode) -> Unit
) {
    when (state) {
        is CountryListState.Loading -> CenteredLoadingIndicator(modifier = modifier)

        is CountryListState.Content -> ItemList(
            modifier = modifier,
            items = state.items,
            onClick = onItemClick
        )

        is CountryListState.Error -> CenteredErrorIndicator(modifier = modifier, text = state.message)
    }
}

@Composable
private fun ItemList(modifier: Modifier = Modifier, items: List<CountryListItem>, onClick: (CountryDetailScreen.CountryCode) -> Unit) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = items,
            key = { it.uniqueId }
        ) { item ->
            CountryItem(
                country = item,
                onClick = { onClick(CountryDetailScreen.CountryCode(it.code)) }
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

@Preview
@Composable
private fun CountryListScreenUiContentPreview() {
    val items = listOf(
        CountryListItem(
            name = "Poland",
            code = "PL",
            emoji = "🇵🇱"
        ),
        CountryListItem(
            name = "Germany",
            code = "GR",
            emoji = "🇵🇱"
        ),
        CountryListItem(
            name = "France",
            code = "FR",
            emoji = "🇵🇱"
        )
    )

    CountryListScreenUi(
        state = CountryListState.Content(items = items),
        onItemClick = {}
    )
}

@Preview
@Composable
private fun CountryListScreenUiLoadingPreview() {
    CountryListScreenUi(
        state = CountryListState.Loading,
        onItemClick = {}
    )
}
