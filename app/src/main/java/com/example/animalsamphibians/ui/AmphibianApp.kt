package com.example.animalsamphibians.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.animalsamphibians.R
import com.example.animalsamphibians.ui.screens.HomeScreen


@Composable
fun AmphibianApp(){
    Scaffold(
        topBar = { AmphibianTopAppBar() }
    ) {
        HomeScreen(modifier = Modifier.padding(it))
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
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.body1
        )
    }
}