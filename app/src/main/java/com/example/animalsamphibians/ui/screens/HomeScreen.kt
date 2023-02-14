package com.example.animalsamphibians.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.animalsamphibians.model.AmphibianModel

@Composable
fun HomeScreen(uiState: AmphibianUiState,modifier: Modifier = Modifier) {
    when(uiState){
        is AmphibianUiState.Loading -> CircularProgressIndicator()
        is AmphibianUiState.Success -> ListAmphibians(modifier= modifier)
        else -> Text(text = "Error", style = MaterialTheme.typography.h3)
    }

}

@Composable
fun ListAmphibians(modifier: Modifier = Modifier) {
    LazyColumn(modifier= modifier
        .padding(8.dp)
        .background(MaterialTheme.colors.background)
    ){
        items(amphiList) {
            AmphibianCard(amphibian = it,modifier = modifier.padding(top = 8.dp))
        }
    }
}

@Composable
fun AmphibianCard(amphibian:AmphibianModel, modifier: Modifier = Modifier) {
    Card(elevation = 8.dp, modifier = modifier) {
        Column(modifier = Modifier) {
            Text(text = amphibian.name, modifier = Modifier
                //.fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp),
//                fontSize = 26.sp,
//                fontWeight = FontWeight.Bold
            style = MaterialTheme.typography.h3
            )
            Text(text = amphibian.description, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
                textAlign = TextAlign.Justify,
//                fontSize = 26.sp,
//                fontWeight = FontWeight.Bold
            style = MaterialTheme.typography.body1
            )

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
                contentAlignment = Alignment.Center
            ) {

                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(amphibian.imgSrc)
                        .crossfade(true)
                        .build(),
                    loading = {
                        CircularProgressIndicator()
                    },
                    //error = painterResource(R.drawable.ic_broken_image),
                    //placeholder = painterResource(R.drawable.loading_img),
                    contentDescription = "Amphibian Image",
                    contentScale = ContentScale.FillBounds,
                )
            }
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
    "this is the big fish of ocean",
    "https://images.pexels.com/photos/7001499/pexels-photo-7001499.jpeg?auto=compress&cs=tinysrgb&w=800&lazy=load")



val amphiList = listOf(
    AmphibianModel(
        "requin",
        "melacetus",
        "this is the big fish of ocean",
        "https://images.pexels.com/photos/4666750/pexels-photo-4666750.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
    ),
    AmphibianModel(
            "cetace",
    "melacetus",
    "this is the big fish of ocean",
"https://images.freeimages.com/images/large-previews/d41/bear-combat-2-1332988.jpg"    ),
    AmphibianModel(
        "dophin",
        "melacetus",
        "this is the big fish of ocean",
        "https://images.pexels.com/photos/3635870/pexels-photo-3635870.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
    ),
)