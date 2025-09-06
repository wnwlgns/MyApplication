package com.example.myapplication.project

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.handleCoroutineException
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
private fun RandomColorApp(){
    Scaffold {innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            RandomColorCard2()
            RandomColorCard()
 }
    }
}

@Composable
private fun RandomColorCard2(){

}
@Composable
private fun RandomColorCard() {
    var color by remember { mutableStateOf(randomColor()) }
    val textColor = if ((color.red * 0.299 + color.green * 0.587 + color.blue * 0.114) > 0.5) {
        Color.Black
    } else {
        Color.White
    }

    androidx.compose.foundation.layout.Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = toRgbString(color),
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color)
                .clickable { color = randomColor() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "탭하면 랜덤 색!",
                color = textColor,
                fontSize = 20.sp
            )
        }
    }
}



private fun toRgbString(color: Color): String {
    val r = (color.red * 255).roundToInt()
    val g = (color.green * 255).roundToInt()
    val b = (color.blue * 255).roundToInt()
    return "rgb(r = $r, g = $g, b = $b)"
}

private fun randomColor(): Color {
    val r= Random.nextInt(0,256)
    val g = Random.nextInt(0,256)
    val b = Random.nextInt(0,256)

    return Color(r,g,b)
}



@Preview
@Composable
private fun Preview(){
    MyApplicationTheme {
        RandomColorApp()
    }
}