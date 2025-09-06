package com.example.myapplication.project

import android.service.quickaccesswallet.QuickAccessWalletService
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random

private val diceList = listOf(
    R.drawable.dice_1_image ,
    R.drawable.dice_2_image ,
    R.drawable.dice_3_image ,
    R.drawable.dice_4_image ,
    R.drawable.dice_5_image ,
    R.drawable.dice_6_image
)



@Composable
 fun RandomDiceApp(){
    var dice1Index by remember {
        mutableStateOf(0)
    }
    var dice2Index by remember {
        mutableStateOf(0)
    }
var total =  dice1Index +1 + dice2Index +1


    Scaffold {

        innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
            , horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "주사위 눈금 합계는: $total"

            )
            Row {

                Image(
                    modifier = Modifier.size(157.dp),
                    painter = painterResource(id = diceList[dice1Index]),
                    contentDescription = null

                )
                Spacer(modifier = Modifier.width(25.dp))
                Image(
                    modifier = Modifier.size(157.dp),
                    painter = painterResource(id = diceList[dice2Index]),
                    contentDescription = null

                )
            }
            Spacer(modifier = Modifier.height(60.dp))

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = CircleShape,
                onClick = {
                    dice1Index = getRandomIndex()
                    dice2Index = getRandomIndex()
                }
            ) {
                Text(text = "주사위 굴리기", fontSize = 13.sp)
            }

        }
    }
}

private fun getRandomIndex(): Int{
    return Random.nextInt(0,6)
}

@Preview
@Composable
private fun Preview() {
    MyApplicationTheme {
        RandomDiceApp()
    }
}