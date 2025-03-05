package com.example.tutorialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.tutorialapp.ui.theme.TutorialAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialAppTheme {
                var name by remember { mutableStateOf("") }
                var names by remember { mutableStateOf(listOf<String>()) }
                Box(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)

                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            OutlinedTextField(
                                value = name,
                                onValueChange = { text ->
                                    name = text
                                },
                                textStyle = TextStyle(
                                    color = Color.Black
                                )
                            )
                            Button(onClick = {
                                if (name.isNotBlank()) {
                                    names = names + name
                                    name = ""
                                }
                            }) { Text(text = "Add") }
                        }
                    }
                    ListNames(names = names)
                }
            }
        }
    }
}

@Composable
fun ListNames(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(names) { currentName ->
            Text(
                text = currentName,
                modifier = Modifier
                    .padding(12.dp)
                    .border(width = 2.dp, color = Color.Red)
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}
