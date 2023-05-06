package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun RowWithButtons(
    previousClick: () -> Unit,
    nextClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = previousClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = nextClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun ArtDescription (
    artName: String,
    nameArtist: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        tonalElevation = 10.dp
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = artName,
                textAlign = TextAlign.Left,
                fontSize = 27.sp,
                fontWeight = FontWeight.Light
            )
            Row()
            {
                Text(
                    text = nameArtist,
                    textAlign = TextAlign.Left,
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "($year)",
                    textAlign = TextAlign.Left,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun ArtWall(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(2.5.dp, Color.LightGray),
        shadowElevation = 10.dp
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.padding(26.dp),
            contentScale = ContentScale.Inside
        )
    }
}

@Composable
fun ArtSpaceCard(
    previousClick: () -> Unit,
    nextClick: () -> Unit,
    painter: Painter,
    artName: String,
    nameArtist: String,
    year: String,
    modifier: Modifier = Modifier.fillMaxSize()
) {

    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        ArtWall(painter = painter, contentDescription = artName)
        Spacer(modifier = Modifier.height(20.dp))
        ArtDescription(artName = artName, nameArtist = nameArtist, year = year)
        RowWithButtons(
            previousClick = previousClick,
            nextClick = nextClick
        )
    }
}

@Composable
fun ArtSpaceApp() {
    var count by remember { mutableStateOf(0) }
    val previousClick = {
        count--
        if (count < 0) count = 9
    }
    val nextClick = {
        count++
        if (count > 9) count = 0
    }

    when (count) {
        0 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.the_ninth_wave),
                artName = stringResource(id = R.string.the_ninth_wave),
                nameArtist = stringResource(id = R.string.the_ninth_wave_artist),
                year = stringResource(id = R.string.the_ninth_wave_year)
            )
        }
        1 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.bashkirtseff),
                artName = stringResource(id = R.string.bashkirtseff),
                nameArtist = stringResource(id = R.string.bashkirtseff_artist),
                year = stringResource(id = R.string.bashkirtseff_year)
            )
        }
        2 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.catherine),
                artName = stringResource(id = R.string.catherine),
                nameArtist = stringResource(id = R.string.catherine_artist),
                year = stringResource(id = R.string.catherine_year)
            )
        }
        3 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.chronos),
                artName = stringResource(id = R.string.chronos),
                nameArtist = stringResource(id = R.string.catherine_artist),
                year = stringResource(id = R.string.chronos_year)
            )
        }
        4 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.lopukhina),
                artName = stringResource(id  = R.string.lopukhina),
                nameArtist = stringResource(id = R.string.lopukhina_artist),
                year = stringResource(id = R.string.lopukhina_year)
            )
        }
        5 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.pushkina),
                artName = stringResource(id = R.string.pushkina),
                nameArtist = stringResource(id = R.string.pushkina_artist),
                year = stringResource(id = R.string.pushkina_year)
            )
        }
        6 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.tarakanova),
                artName = stringResource(id = R.string.tarakanova),
                nameArtist = stringResource(id = R.string.tarakanova_artist),
                year = stringResource(id = R.string.tarakanova_year)
            )
        }
        7 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.the_rider),
                artName = stringResource(id = R.string.rider),
                nameArtist = stringResource(id = R.string.rider_artist),
                year = stringResource(id = R.string.rider_year)
            )
        }
        8 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.young_girl),
                artName = stringResource(id = R.string.young_girl),
                nameArtist = stringResource(id = R.string.young_girl_artist),
                year = stringResource(id = R.string.young_girl_year)
            )
        }
        9 -> {
            ArtSpaceCard(
                previousClick = previousClick,
                nextClick = nextClick,
                painter = painterResource(id = R.drawable.annushka),
                artName = stringResource(id = R.string.annushka),
                nameArtist = stringResource(id = R.string.annushka_artist),
                year = stringResource(id = R.string.annushka_year)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceCard(
            previousClick = {  },
            nextClick = {  },
            painter = painterResource(id = R.drawable.the_ninth_wave),
            artName = stringResource(id = R.string.the_ninth_wave),
            nameArtist = stringResource(id = R.string.the_ninth_wave_artist),
            year = stringResource(id = R.string.the_ninth_wave_year)
        )
    }
}