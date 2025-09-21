package com.example.graphql.countryDetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.graphql.navigation.CountryDetailScreen.CountryId

@Composable
fun CountryDetailScreenUi(
    modifier: Modifier = Modifier,
    id: CountryId
) {
    Text("detail ${id.id}")
}