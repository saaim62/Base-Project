package com.example.mapBoxAndOneSignal.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mapBoxAndOneSignal.core.Resource
import com.example.mapBoxAndOneSignal.core.koin.providers.models.Player

@Composable
fun MainScreen(viewModel: MainViewModel) {
    var players = remember { mutableStateOf(List(size = 10) { Player("", "") }) }
    val query = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = query.value,
            onValueChange = { query.value = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))
        viewModel.searchPlayers(query.value) { apiResponse ->
            when (apiResponse) {
                is Resource.Success -> {
                    players.value = apiResponse.data.players
                }
                is Resource.Error -> {
                }
                is Resource.Loading -> {
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            val playerList: List<Player> = players.value
            playerList.let {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(it) { player ->
                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            elevation = 4.dp
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    modifier = Modifier.padding(16.dp),
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = null
                                )
                                Column(modifier = Modifier.weight(1f)) {
                                    player.strPlayer?.let {
                                        Text(
                                            text = it,
                                            fontWeight = FontWeight.Bold,
                                            style = MaterialTheme.typography.h6
                                        )
                                    }
                                    player.dateBorn?.let {
                                        Text(
                                            text = it,
                                            style = MaterialTheme.typography.subtitle1,
                                            color = Color.DarkGray
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


