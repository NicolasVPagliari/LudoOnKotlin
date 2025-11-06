package br.com.nicolasvpagliari.ludoon.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.nicolasvpagliari.ludoon.R
import br.com.nicolasvpagliari.ludoon.models.Feed
import br.com.nicolasvpagliari.ludoon.models.Story
import br.com.nicolasvpagliari.ludoon.ui.theme.StoryCircleColor
import br.com.nicolasvpagliari.ludoon.ui.theme.spacingSmall
import coil.compose.AsyncImage
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import br.com.nicolasvpagliari.ludoon.ui.theme.spacingMedium

@Composable
fun FeedItem(feed: Feed) {
    Column {
        Row(
            modifier = Modifier
                .padding(spacingMedium)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {

            AsyncImage(
                model = feed.userAvatar,
                contentDescription = stringResource(
                    R.string.story_content_description,
                    feed.userNickName
                ),
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.CenterVertically)
                    .fillMaxSize()
                    .clip(CircleShape)
                    .border(2.dp, StoryCircleColor, CircleShape),
                contentScale = ContentScale.Fit
                //placeholder = painterResource(R.drawable.placeholder), // opcional
                //error = painterResource(R.drawable.error) // opcional
            )

            Column(
                modifier = Modifier
                    .padding(8.dp, 8.dp)
            ) {
                Text(
                    feed.userNickName,
                    modifier = Modifier
                        .height(18.dp),
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    fontSize = 16.sp
                )

                Text(
                    feed.localName,
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                )
            }
        }

        AsyncImage(
            model = feed.imageUrl,
            contentDescription = stringResource(
                R.string.feed_content_description,
                feed.userNickName
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(384.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop

            //placeholder = painterResource(R.drawable.placeholder), // opcional
            //error = painterResource(R.drawable.error) // opcional
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(spacingMedium)
        ) {

            Icon(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Icon",
                Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text("635", modifier = Modifier
                .align(Alignment.CenterVertically))

            Spacer(modifier = Modifier.size(16.dp))

            Icon(
                painter = painterResource(R.drawable.chatbubble),
                contentDescription = "Icon",
                Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text("635", modifier = Modifier
                .align(Alignment.CenterVertically))

            Spacer(modifier = Modifier.size(16.dp))

            Icon(
                painter = painterResource(R.drawable.send),
                contentDescription = "Icon",
                modifier = Modifier.size(20.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text("12", modifier = Modifier
                .align(Alignment.CenterVertically))
        }

        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .padding(8.dp, 0.dp)
        ) {

            Row {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(feed.userNickName)
                        }
                        append(" ")
                        append(feed.description)
                    }
                )
            }

            Spacer(modifier = Modifier.size(4.dp))

            Text(feed.postedAgo, style = TextStyle(fontSize = 12.sp))
        }

        Spacer(modifier = Modifier.size(8.dp))
    }

}

@Preview
@Composable
fun FeedItemPreview(modifier: Modifier = Modifier) {
    FeedItem(
        Feed(
            "across_the_board",
            "São Paulo",
            "https://heiderlopes.github.io/my-website/img/ludoon/editoras/across_the_board.png",
            "https://heiderlopes.github.io/my-website/img/ludoon/editoras/calamity.webp",
            "Novo lançamento chegando na loja! 🔥 #boardgames #ludoon",
            "há 2 horas"
        ),
    )
}