@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.amphibiansapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.amphibiansapp.R
import com.example.amphibiansapp.ui.screens.AmphibiansViewModel
import com.example.amphibiansapp.ui.screens.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AmphibiansApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { TopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val amphibiansViewModel: AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
            HomeScreen(
                amphibiansUiState = amphibiansViewModel.amphibiansState,
                retryAction = amphibiansViewModel::getAmphibians,
                contentPadding = it,
            )
        }
    }

}

@Composable
fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}

