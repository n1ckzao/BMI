package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.VertexMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculate
import br.senai.sp.jandira.bmi.utils.numberConvertToLocale

@Composable
fun BMIResultScreen(navegacao: NavHostController?){
    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("user_file", Context.MODE_PRIVATE)
    val userAge = userFile.getInt("user_age", 0)
    val userHeight = userFile.getFloat("user_height", 0.0f)
    val userWeight = userFile.getFloat("user_weight", 0.0f)

    //Obter os dados do imc do usuario
    val bmi = bmiCalculate(
        userWeight.toInt(),
        userHeight.toDouble().div(100)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xff823234),
                        Color(0xFF399699),
                        Color(0xFF541E60)
                    )
                )
            )
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),

            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.result),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(38.dp)
                    .weight(1f)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(7f),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(6f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    Row (
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Card (
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .size(120.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 4.dp,
                                brush = Brush.linearGradient(
                                    listOf(
                                        Color(0xFF2E6FB6),
                                        Color(0xFF021A9F)
                                    )
                                )
                            )
                        ) {
                            Column (
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = numberConvertToLocale(bmi.bmi.second),
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 40.sp
                                )
                            }
                        }
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = bmi.bmi.first,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 30.sp
                        )
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                    ){
                        Card(
                            modifier = Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                        ) {
                            Row (
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = stringResource(R.string.age)
                                    //text = stringResource(R.string.hi) + ", $userName!"
                                    )
                                    Text(
                                        text = "$userAge",
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp
                                    )
                                }
                                VerticalDivider(
                                    modifier = Modifier
                                        .height(70.dp)
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = stringResource(R.string.weight)
                                    )
                                    Text(
                                        text = "$userWeight kg",
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp
                                    )
                                }
                                VerticalDivider(
                                    modifier = Modifier
                                        .height(70.dp))
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = stringResource(R.string.height),
                                    )
                                    Text(
                                        text = "$userHeight m",
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp
                                    )
                                }
                            }
                        }
                    }
                    Column (
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                            .height(250.dp)
                    ){}
                    HorizontalDivider()
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.New_Calc),
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview(){
    BMIResultScreen(navegacao = null)
}
