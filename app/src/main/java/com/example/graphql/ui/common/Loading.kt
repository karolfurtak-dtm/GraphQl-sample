package com.example.graphql.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CenteredLoadingIndicator(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun CenteredErrorIndicator(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, textAlign = TextAlign.Center)
}