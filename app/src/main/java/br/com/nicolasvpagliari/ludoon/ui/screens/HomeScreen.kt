package br.com.nicolasvpagliari.ludoon.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.nicolasvpagliari.ludoon.data.repository.feeds
import br.com.nicolasvpagliari.ludoon.data.repository.stories
import br.com.nicolasvpagliari.ludoon.ui.components.FeedItem
import br.com.nicolasvpagliari.ludoon.ui.components.FeedList
import br.com.nicolasvpagliari.ludoon.ui.components.LudoOnBottomBar
import br.com.nicolasvpagliari.ludoon.ui.components.LudoOnTopBar
import br.com.nicolasvpagliari.ludoon.ui.components.StoryList

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { LudoOnTopBar() },
        bottomBar = { LudoOnBottomBar() },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) { padding ->
        Column {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
            ) {
                StoryList(stories)

                FeedList(feeds)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen()
}