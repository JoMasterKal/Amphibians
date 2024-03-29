package com.example.animalsamphibians.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.animalsamphibians.R
import com.example.animalsamphibians.ui.screens.AmphibianVIewModel
import com.example.animalsamphibians.ui.screens.HomeScreen


@Composable
fun AmphibianApp(viewModel: AmphibianVIewModel){
    Scaffold(
        topBar = { AmphibianTopAppBar() }
    ) {
        HomeScreen(viewModel.amphibianUiState,modifier = Modifier.fillMaxSize().padding(it))
    }
}

@Composable
fun AmphibianTopAppBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {


        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h2
        )
    }
}