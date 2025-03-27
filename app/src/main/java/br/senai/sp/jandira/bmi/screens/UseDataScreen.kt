package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(modifier: Modifier = Modifier){

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("user_file", Context.MODE_PRIVATE)
    val userName = userFile.getString("user_name", "")
    val editor = userFile.edit()

    var weightState = remember {
        mutableStateOf("")
    }
    var ageState = remember {
        mutableStateOf("")
    }
    var heightState = remember {
        mutableStateOf("")
    }


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
                    text = stringResource(R.string.hi) + ", $userName!",
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
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center

                    ) {
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card (
                                modifier = Modifier
                                    .padding(bottom = 10.dp)
                                    .size(100.dp),
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

                            ){
                                Image(
                                painter = painterResource(
                                    R.drawable.man
                                ),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .width(130.dp)
                                    .height(40.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Blue
                                )
                            ) {
                                Text(
                                    text = stringResource(
                                        R.string.male
                                    )
                                )
                            }

                        }
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card (
                                modifier = Modifier
                                    .padding(bottom = 10.dp)
                                    .size(100.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 4.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFFAD1649),
                                            Color(0xFF340C32)
                                        )
                                    )
                                )

                            ){
                                Image(
                                    painter = painterResource(
                                        R.drawable.woman
                                    ),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                            }

                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .width(130.dp)
                                    .height(40.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Magenta
                                )
                            ) {
                                Text(
                                    text = stringResource(
                                        R.string.female
                                    )
                                )
                            }
                        }

                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .width(300.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                    OutlinedTextField(
                        value = ageState.value,
                        onValueChange = {
                            ageState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                imageVector =  Icons.Default.Numbers,
                                contentDescription = ""
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(R.string.age)
                            )
                        },
                        shape = RoundedCornerShape(16.dp)
                    )
                        OutlinedTextField(
                        value = weightState.value,
                        onValueChange = {
                            weightState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    imageVector =  Icons.Default.Balance,
                                    contentDescription = ""
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(R.string.weight)
                                )
                            },
                            shape = RoundedCornerShape(16.dp)
                        )
                        OutlinedTextField(
                        value = heightState.value,
                        onValueChange = {
                            heightState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    imageVector =  Icons.Default.Height,
                                    contentDescription = ""
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(R.string.height)
                                )
                            },
                            shape = RoundedCornerShape(16.dp)
                        )
                    }
                    Button(
                        onClick = {
                            val age = ageState.value
                            val weight = weightState.value.toFloat()
                            val height = heightState.value.toFloat()

                            editor.putString("user_age", age)
                            editor.putFloat("user_weight", weight)
                            editor.putFloat("user_height", height)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.calculate)
                        )
                    }
                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview(){
    UserDataScreen()
}