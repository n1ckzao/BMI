package br.senai.sp.jandira.bmi.screens

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cabin
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var nameState = remember {
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
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(
                    R.drawable.weightlifting
                ),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        top = 32.dp
                    )
            )
            Text(
                text = stringResource(
                    R.string.welcome
                ),
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                ),
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF6D0785),
                            Color(0xFF980E11)
                        )
                    )
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ){
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)

                    ){
                        Text(
                            text = stringResource(
                                R.string.your_name
                            ),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        TextField(
                            value = nameState.value,
                            onValueChange = {
                                nameState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 8.dp
                                ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Cabin,
                                    contentDescription = "",
                                    tint = Color.Red
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Sentences
                            )

                        )
                    }
                    Button(
                        onClick = {}) {
                        Text(
                            text = stringResource(
                                R.string.next
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}