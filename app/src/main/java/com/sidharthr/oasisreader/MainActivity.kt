package com.sidharthr.oasisreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sidharthr.oasisreader.ui.theme.OasisReaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OasisReaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            LazyColumn(
                                content = {
                                    items(sampleArticlesList.size) { index ->
                                        ArticleCard(articleItem = sampleArticlesList[index], onClick = {
                                            navController.navigate("article")
                                        })
                                    }
                                })
                        }
                        composable("article") {
                            Text(text = "Article")
                        }
                    }


                }
            }
        }
    }
}

// A composable card of an article, contains the title, excerpt, and date.
@Composable
fun ArticleCard(articleItem: ArticleItem, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick()  },
    ) {
        Column {
            Text(
                text = articleItem.title,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = articleItem.excerpt,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OasisReaderTheme {
//        Greeting("Android")
    }
}