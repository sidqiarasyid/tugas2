package com.chevalier.sidqiarasyid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.chevalier.sidqiarasyid.ui.theme.Tugas2Theme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas2Theme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Latihan Column")
                        },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(
                            containerColor = Color.Blue,
                            titleContentColor = Color.White

                        )
                    )
                }
                ) { innerPadding ->
                    Body(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Body(modifier: Modifier){
    val num = remember { mutableStateOf(0) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Click the button to keep increasing the number")
        Text(num.value.toString())
        AddButton {
            num.value++
        }
    }
}

@Composable
fun AddButton(onClick: ()-> Unit){
    Button(
        onClick = onClick,
        colors = ButtonColors(Color.Blue, Color.White, Color.Gray, Color.Gray)
    ) {
        Text("Click Me!")
    }
}


