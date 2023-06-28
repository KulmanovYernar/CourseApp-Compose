package com.example.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courseapp.data.DataSource
import com.example.courseapp.model.Topic
import com.example.courseapp.ui.theme.CourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}

@Composable
fun CourseApp(modifier: Modifier = Modifier) {
    CourseList(listTopics = DataSource.topics)
}

@Composable
fun CourseList(listTopics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier) {
        items(listTopics){topic ->
            CourseItem(topic = topic)
        }

    }
}

@Composable
fun CourseItem(topic: Topic, modifier: Modifier = Modifier) {
    Card{
        Row{
            Box {
                Image(
                    painter = painterResource(id = topic.imageResourceId),
                    contentDescription = stringResource(
                        id = topic.titleResourceId
                    ),
                    modifier = modifier
                        .width(68.dp)
                        .height(68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }


            Column {
                Text(
                    text = stringResource(topic.titleResourceId),
                    modifier = modifier.padding(8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(R.drawable.ic_grain),
                        contentDescription = "null",
                        modifier = modifier.padding(start = 16.dp)

                        )
                    Text(
                        text = topic.studentsCount.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = modifier.padding(start = 8.dp)
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseAppPreview() {
    CourseAppTheme {
        CourseApp()
    }
}