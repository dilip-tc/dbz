package com.dk.dbz.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.dk.dbz.data.api.model.ZCharacter

@Composable
fun HomeScreen(){
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()
    
    LazyColumn{
        if (state.isEmpty()){
            item{
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }

        items(state) {zCharacter:ZCharacter ->
            ImageCard(zCharacter)
        }
    }



}

@Composable
fun ImageCard(zCharacter: ZCharacter){
    val imagePainter = rememberImagePainter(data = zCharacter.image)

    Card(shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(16.dp)
    ) {
        Box{
            Image(
                painter = imagePainter,
                contentDescription = "image_${zCharacter.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                contentScale = ContentScale.FillBounds
            )

            Surface (
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ){
                    Text(text = "Z Name : ${zCharacter.name}")
                    Text(text = "Race : ${zCharacter.race}")
                    Text(text = "Max Ki : ${zCharacter.maxKi}")
                }
            }





        }

    }
}
