package br.com.fiap.saudeplena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.saudeplena.ui.theme.SaudePlenaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaudePlenaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF070D1C),
                ) {
                    LoginScreen()
                }
            }
        }
    }
}


@Composable
fun LoginScreen() {
    val image = painterResource(R.drawable.plus)
    Column() {
      Surface(
          modifier = Modifier.fillMaxWidth()
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
                      Modifier.height(40.dp)
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
