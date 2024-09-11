package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibiansapp.network.AmphibiansData
import com.example.amphibiansapp.ui.AmphibiansApp

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction : () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AmphibiansUiState.Success -> AmphibiansListScreen(amphibiansList = amphibiansUiState.amphibiansList, modifier = modifier)

        is AmphibiansUiState.Error -> ErrorScreen(retryAction = retryAction, modifier = modifier.fillMaxSize())
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier) {
    TODO("Not yet implemented")
}

@Composable
fun AmphibiansListScreen(amphibiansList: List<AmphibiansData>, modifier: Modifier) {
    TODO("Not yet implemented")
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    TODO("Not yet implemented")
}

@Composable
private fun AmphibiansCardView() {
    Card {
        Column {
            Text("Title")
            Image(
                painter = painterResource(id = android.R.drawable.ic_secure),
                contentDescription = null
            )
            Text("Description")
        }
    }
}

@Preview
@Composable
fun AmphibiansAppPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        AmphibiansCardView()
    }
}