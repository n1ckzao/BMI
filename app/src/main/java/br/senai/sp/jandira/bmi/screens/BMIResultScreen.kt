package br.senai.sp.jandira.bmi.screens

import android.content.Context
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculate
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
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
    val result = bmiCalculate(
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
                                color = result.color
                            )
                        ) {
                            Column (
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
//                                Text(
//                                    text = numberConvertToLocale(result.bmi.second),
//                                    color = Color.Black,
//                                    fontWeight = FontWeight.SemiBold,
//                                    fontSize = 40.sp
//                                )
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
                            text = result.bmi.first,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp
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
                    ){
                        BmiLevel(
                            leftText = "Underweight",
                            rightText = "< 18.5",
                            bulletColor = colorResource(R.color.light_blue),
                            background = if(result.status == BmiStatus.UNDER_WEIGHT) colorResource(R.color.light_blue) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Normal",
                            rightText = "18.6 - 24.9",
                            bulletColor = colorResource(R.color.light_green),
                            background = if(result.status == BmiStatus.NORMAL) colorResource(R.color.light_green) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Overweight",
                            rightText = "25.0 - 29.9",
                            bulletColor = colorResource(R.color.yellow),
                            background = if(result.status == BmiStatus.OVER_WEIGHT) colorResource(R.color.yellow) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Obesity class I",
                            rightText = "30.0 - 34.9",
                            bulletColor = colorResource(R.color.light_orange),
                            background = if(result.status == BmiStatus.OBESITY_1) colorResource(R.color.light_orange) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Obesity class II",
                            rightText = "35.0 - 39.9",
                            bulletColor = colorResource(R.color.dark_orange),
                            background = if(result.status == BmiStatus.OBESITY_2) colorResource(R.color.dark_orange) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Obesity class III",
                            rightText = "> 39.9",
                            bulletColor = colorResource(R.color.red),
                            background = if(result.status == BmiStatus.OBESITY_3) colorResource(R.color.red) else Color.Transparent
                        )
                    }
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
