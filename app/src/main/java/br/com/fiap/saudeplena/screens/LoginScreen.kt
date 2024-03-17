package br.com.fiap.saudeplena.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextFieldDefaults
import androidx.navigation.NavController
import br.com.fiap.saudeplena.ui.theme.SaudePlenaTheme

@Composable
fun LoginScreen (navController: NavController) {
    //LoginTopHeader()
    LoginBody()
    Button(
        onClick = {
            navController.navigate("heartbeat")
        }
    ) {
        Text(text = "Login")
    }
}


/*
@Composable
fun LoginTopHeader() {
    val image = painterResource(R.drawable.plus)
    Column() {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            color = Color(0xFF222D48),
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
        ){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(0.dp),
                ) {
                    Image(
                        painter = image,
                        contentDescription = null,
                        Modifier
                            .height(40.dp)
                            .width(40.dp)
                    )

                    Text("Login",
                        color = Color(0xFFFFFFFF),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
            }

        }
    }
}
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBody() {

    var textFieldValue = remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ){
                Text(
                    text = "Email",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFFFFF)
                )

                TextField(
                    value = textFieldValue.value,
                    onValueChange = { value ->
                        textFieldValue.value = value
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF131A30)),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color(0xFF0E52C7),
                        placeholderColor = Color.Gray,
                    )
                )
            }
        }
    }
}
