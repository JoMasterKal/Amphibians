package com.example.animalsamphibians.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.animalsamphibians.model.AmphibianModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

}

@Composable
fun ListAmphibians(modifier: Modifier = Modifier) {
    LazyColumn(modifier= modifier
        .padding(8.dp)
        .background(MaterialTheme.colors.background)
    ){
        //items()
    }
}

@Composable
fun AmphibianCard(amphibian:AmphibianModel, modifier: Modifier = Modifier) {
    Card(elevation = 8.dp,) {
        Column(modifier = modifier) {
            Text(text = amphibian.name, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = amphibian.description, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
                textAlign = TextAlign.Justify,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                //error = painterResource(R.drawable.ic_broken_image),
                //placeholder = painterResource(R.drawable.loading_img),
                contentDescription = "Amphibian Image",
                contentScale = ContentScale.FillBounds
            )
        }
    }

}


@Composable
@Preview
fun CardPreview() {
    AmphibianCard(amphibian = amphi)
}

val amphi = AmphibianModel("Balena",
    "melacetus",
    "this is the big fish of ocean","")