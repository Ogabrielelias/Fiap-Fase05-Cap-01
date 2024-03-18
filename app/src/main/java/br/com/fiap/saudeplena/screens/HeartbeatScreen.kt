package br.com.fiap.saudeplena.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.saudeplena.R
import br.com.fiap.saudeplena.ui.theme.Blue60
import br.com.fiap.saudeplena.ui.theme.Blue70
import br.com.fiap.saudeplena.ui.theme.Gray50
import br.com.fiap.saudeplena.ui.theme.Red40
import br.com.fiap.saudeplena.ui.theme.Red80

@Composable
fun HeartbeatScreen (navController: NavController) {
    HeartbeatBody()
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeartbeatBody() {
    val scrollState = rememberScrollState()
    val scrollState2 = rememberScrollState()
        FlexColumnLayout{
            Row ( modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Seta para a esquerda",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(26.dp),
                    tint = Color.White
                )
                TextFun(text = "Batimentos Cardíacos", size = 28.sp)
            }
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .background(Red80, RoundedCornerShape(16.dp))
                        .fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Heart Icon",
                        tint = Red40,
                        modifier = Modifier.size(25.dp)
                    )
                }
                TextFun("95", 100.sp)
                TextFun("BPM", 35.sp, Gray50)
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Blue70, RoundedCornerShape(16.dp))
                ) {
                    Surface(
                        modifier = Modifier
                            .width(maxWidth)
                            .height(100.dp)
                            .horizontalScroll(scrollState)
                            .padding(16.dp)
                            .background(Blue70),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Blue70),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier
                                    .background(Blue70)
                                    .align(Alignment.CenterStart),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                RoundedBoxWithText("1 Dia")
                                RoundedBoxWithText("1 Semana")
                                RoundedBoxWithText("1 Mês")
                                RoundedBoxWithText("Todos")
                            }
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.heartbeat_graphic),
                    contentDescription = "grafico de batimentos cardiacos"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Blue60, RoundedCornerShape(16.dp))
                        .align(Alignment.CenterVertically)
                        .padding(16.dp),
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .background(Blue60)
                        ) {
                            TextFun(text = "3 Alterações Cardíacas", size = 20.sp)
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Config Icon",
                                tint = Color.White,
                                modifier = Modifier.size(25.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = "Telephone Icon",
                                tint = Color.White,
                                modifier = Modifier.size(25.dp)
                            )

                        }
                        BoxWithConstraints(
                            modifier = Modifier
                                .background(Blue60, RoundedCornerShape(16.dp))
                        ) {
                            Surface(
                                modifier = Modifier
                                    .width(maxWidth)
                                    .height(maxHeight)
                                    .horizontalScroll(scrollState2)
                                    .padding(16.dp)
                                    .background(Blue60),
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Blue60),
                                    contentAlignment = Alignment.TopStart
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .background(Blue60)
                                            .align(Alignment.CenterStart),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.graphic),
                                            contentDescription = "grafico de batimentos cardiacos",
                                            modifier = Modifier.size(200.dp)
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.graphic_danger),
                                            contentDescription = "grafico de batimentos cardiacos",
                                            modifier = Modifier.size(200.dp)
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.graphic),
                                            contentDescription = "grafico de batimentos cardiacos",
                                            modifier = Modifier.size(200.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


@Composable
fun FlexColumnLayout(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        content = content
    )
}

@Composable
fun TextFun(text: String, size: TextUnit = 16.sp, color: Color = Color.White) {
    Text(text = text,
        fontSize = size,
        fontWeight = FontWeight.Bold,
        color = color,
        modifier = Modifier.padding(start = 8.dp))
}

@Composable
fun BoxWithGraphic() {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(130.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(){
            Text(text = "1 Dia",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Blue70,)

            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Heart Icon",
                tint = Red40,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@Composable
fun RoundedBoxWithText(text: String) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(50.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(2.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(){
            Text(text = text,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Blue70,)
        }
    }
}

