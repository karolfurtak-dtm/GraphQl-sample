package com.example.graphql.countryDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graphql.domain.CountryDetail
import com.example.graphql.navigation.CountryDetailScreen.CountryCode

@Composable
fun CountryDetailScreenUi(
    modifier: Modifier = Modifier,
    id: CountryCode
) {
    val detail = CountryDetail(
        name = "Polska",
        capital = "Warszawa",
        code = "PL",
        emoji = "🇵🇱",
        languages = listOf(
            CountryDetail.Language("Polski"),
            CountryDetail.Language("Angielski")
        )
    )

    Content(detail)
}

@Composable
private fun Content(
    detail: CountryDetail,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = detail.emoji,
                fontSize = 48.sp,
                modifier = Modifier.padding(end = 12.dp)
            )
            Column {
                Text(
                    text = detail.name,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = detail.code,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }

        detail.capital?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        Text(
            text = "Languages:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        detail.languages.forEach { language ->
            Text(
                text = "• ${language.name}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
            )
        }
    }
}