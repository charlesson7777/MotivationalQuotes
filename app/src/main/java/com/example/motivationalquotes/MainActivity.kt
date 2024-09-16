package com.example.motivationalquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Keep
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction.Companion.Go
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivationalquotes.ui.theme.MotivationalQuotesTheme
import androidx.compose.material3.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotivationalQuotesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MotivationalQuotes()
                }

            }
        }
    }
}
/*
* this MotivationalQuotes() composable function is the main function that defines
* the structure and behaviors of the way the quotes will be displayed and change button
* */
@Composable
fun MotivationalQuotes(){
    //I used a list because I wanted to access random(), first(), and last() builtin
    //functions
    val quotes = listOf(
        "Dreams don't work unless you do.",
        "Go the extra mile.",
        "Keep your face always toward the sunshine--and shadows will fall behind you.",
        "What defines us is how well we rise after falling.",
        "Make each day your masterpiece.",
        "Wherever you go, go with all your heart",
        "Turn your wounds into wisdom."
    )

    var recentQuote by remember{mutableStateOf(quotes.first())}
    Column(
        modifier = Modifier.fillMaxSize().padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = recentQuote,
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 22.dp)
        )
        Button(
            onClick = {
                recentQuote = quotes.random()
            }){
            Text(text = "Change the quote")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MotivationalQuotesTheme {
       MotivationalQuotes()
    }
}