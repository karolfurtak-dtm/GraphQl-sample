package com.example.graphql.countryList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CountryListScreenUi(
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit
) {
    LazyColumn(
        modifier.fillMaxSize()
    ) {
        items(100) {
            Text(
                "note $it", Modifier
                    .padding(20.dp)
                    .clickable(
                        onClick = {
                            onItemClick(it)
                        }
                    ))
        }
    }
}