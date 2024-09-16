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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction.Companion.Go
import androidx.compose.ui.tooling.preview.Preview
import com.example.motivationalquotes.ui.theme.MotivationalQuotesTheme

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
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MotivationalQuotesTheme {
       MotivationalQuotes()
    }
}