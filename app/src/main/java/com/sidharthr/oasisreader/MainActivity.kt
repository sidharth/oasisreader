package com.sidharthr.oasisreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sidharthr.oasisreader.ui.theme.OasisReaderTheme

class MainActivity : ComponentActivity() {

    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    val monospaceFamily = FontFamily(Font( GoogleFont("Space Mono"), provider));

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
                    NavHost(
                        navController = navController,
                        startDestination = "home") {
                        composable("home") {
                            LazyColumn(
//                                modifier=Modifier.verticalScroll(rememberScrollState()),
                                content = {
                                    item {
                                        Text(
                                            modifier = Modifier.padding(16.dp),
                                            fontSize = 24.sp,
                                            fontFamily = monospaceFamily,
                                            fontWeight = FontWeight.ExtraBold,
                                            text = "Oasis Reader")
                                    }
                                    items(sampleArticlesList.size) { index ->
                                        ArticleCard(articleItem = sampleArticlesList[index], onClick = {
                                            navController.navigate("article")
                                        })
                                    }
                                })
                        }
                        composable("article", exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                                animationSpec = tween(700)
                            )
                        }) {
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
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .clickable { onClick() }){
        Text(
            modifier = Modifier.padding(bottom=2.dp),
            fontSize=20.sp,
            text = articleItem.title
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(modifier= Modifier
                .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 8.dp, vertical = 2.dp)
                .alpha(0.6f),
                fontSize = 16.sp, text="theinformation.com")
            Text(modifier= Modifier
                .padding(horizontal = 8.dp)
                .alpha(0.8f), fontSize = 16.sp, text="5 hours ago")
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