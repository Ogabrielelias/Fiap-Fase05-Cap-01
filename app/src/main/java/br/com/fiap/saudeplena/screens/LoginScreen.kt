package br.com.fiap.saudeplena.screens

import android.text.TextUtils
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

@Composable
fun LoginScreen (navController: NavController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        LoginTopHeader()
        LoginBody()

        val openAlertDialog = remember { mutableStateOf(true) }

        when {
            openAlertDialog.value -> {
                AlertDialog(
                    title = {
                        Text(
                            text = "Conta de testes!" ,
                            color = Color.Blue,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    text = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "E-mail: admin@fiap.com.br",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp
                            )

                            Text(
                                text = "Senha: admin123",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp
                            )
                        }
                    },
                    onDismissRequest = {

                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                openAlertDialog.value = false
                            }
                        ) {
                            Text("Ok")
                        }
                    },
                )
            }
        }
    }
}

@Composable
fun LoginTopHeader() {
    val image = painterResource(R.drawable.plus)
    Column() {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
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

fun validateLoginInputs (email:String, senha:String) : Boolean {
    println(!TextUtils.isEmpty(email) &&
            Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
            senha.length >= 8)
    if(
        !TextUtils.isEmpty(email) &&
        Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
        senha.length >= 8
        ) return true

    return false
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBody() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {

            FormLogin(onSend = {email, senha ->

            })

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(2.dp)
                        .background(Color(0xFF131A30))
                ){}
                Text("Ou", color = Color.White)
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(2.dp)
                        .background(Color(0xFF131A30))
                ){}
            }
        }
    }
}

@Composable
fun FormLogin(
    onSend:(email:String, senha:String) -> Unit,
    error:Boolean = false
){

    val buttonDisabled = remember { mutableStateOf(true) }

    var emailValue = remember {
        mutableStateOf("")
    }

    var senhaValue = remember {
        mutableStateOf("")
    }


    Column (
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Input(
            label = "Email",
            value = emailValue.value,
            onChange = { value ->
                emailValue.value = value
                buttonDisabled.value = !validateLoginInputs(
                    value,
                    senhaValue.value
                )
                       },
            frontImage = R.drawable.mail,
            isError = error
        )

        Input(
            label = "Senha",
            value = senhaValue.value,
            onChange = { value ->
                senhaValue.value = value
                buttonDisabled.value = !validateLoginInputs(
                    emailValue.value,
                    value
                )
                       },
            type = "password",
            frontImage = R.drawable.lock,
            isError = error
        )
    }

    Button(
        enabled = !buttonDisabled.value,
        onClick = { -> onSend(emailValue.value, senhaValue.value)},
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding= PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFF0D65FB),
            disabledContainerColor = Color(0XFF162A4D)
        )
    ){
        Text(
            "Continuar  ➔",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Input(
    label:String,
    value:String,
    onChange:(value:String) -> Unit,
    type: String = "",
    frontImage:Int,
    isError: Boolean = false
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
                    isError=isError,
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
                    leadingIcon = {
                        Image(
                        painter = painterResource(frontImage),
                        contentDescription = null,
                        Modifier
                            .size(24.dp)
                        )
                                  },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                            passwordVisible = !passwordVisible
                            }
                        ) {
                            var image = R.drawable.eye
                            if(passwordVisible) image = R.drawable.eyeoff
                            Image(
                                painter = painterResource(image),
                                contentDescription = null,
                                Modifier
                                    .size(32.dp)
                            )
                        }
                    }
                )
            }else {
                OutlinedTextField(
                    value = value,
                    onValueChange = { value ->
                        onChange(value)
                    },
                    isError = isError,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { state ->
                            inputIsFocused.value = state.toString()
                        },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Image(
                            painter = painterResource(frontImage),
                            contentDescription = null,
                            Modifier
                                .size(24.dp)
                        )
                    },
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