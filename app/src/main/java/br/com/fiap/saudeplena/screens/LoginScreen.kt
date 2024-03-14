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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import br.com.fiap.saudeplena.R
import br.com.fiap.saudeplena.ui.theme.SaudePlenaTheme

@Composable
fun LoginScreen (navController: NavController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        LoginTopHeader()
        LoginBody()
    }
}


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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBody() {

    var emailValue = remember {
        mutableStateOf("")
    }

    var senhaValue = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Input(
                label = "Email",
                value = emailValue.value,
                onChange = { value -> emailValue.value = value }
            )

            Input(
                label = "Senha",
                value = senhaValue.value,
                onChange = { value -> senhaValue.value = value },
                type = "password"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Input(
    label:String,
    value:String,
    onChange:(value:String) -> Unit,
    type: String = ""
){

    var inputIsFocused = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }
    var passwordVisible : Boolean by remember{
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ){
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF)
        )
        OutlinedTextFieldBackground(
            Color(0xFF131A30),
            isFocused = inputIsFocused.value == "Active"
        ) {
            if(type === "password"){
                OutlinedTextField(
                    value = value,
                    onValueChange = { value ->
                        onChange(value)
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { state ->
                            inputIsFocused.value = state.toString()
                        },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color(0xFF0E52C7),
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisible = !passwordVisible
                        }) {
                            Image(painter = painterResource(R.drawable.plus),
                                contentDescription = null,
                                Modifier
                                    .height(10.dp)
                                    .width(10.dp))
                        }
                    }
                )
            }else {
                OutlinedTextField(
                    value = value,
                    onValueChange = { value ->
                        onChange(value)
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { state ->
                            inputIsFocused.value = state.toString()
                        },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color(0xFF0E52C7),
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}
@Composable
fun OutlinedTextFieldBackground(
    color: Color,
    isFocused: Boolean,
    content: @Composable () -> Unit
) {

    var boxModifier = Modifier
        .padding(top = 8.dp)
        .background(
            color,
            shape = RoundedCornerShape(5.dp)
        )

    if (isFocused){
        boxModifier = Modifier
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp),
                ambientColor = Color(0xFF0E52C7),
                spotColor = Color(0xFF0E52C7),
            )
            .background(
                color,
                shape = RoundedCornerShape(5.dp)
            )
    }

    Box {
        Box(
            modifier = boxModifier.matchParentSize()
        )
        content()
    }
}