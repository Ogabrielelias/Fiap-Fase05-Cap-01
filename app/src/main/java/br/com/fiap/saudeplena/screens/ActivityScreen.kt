package br.com.fiap.saudeplena.screens

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.captionBarPadding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.saudeplena.R
import br.com.fiap.saudeplena.ui.theme.SaudePlenaTheme
import java.sql.Time

@Composable
fun ActivityScreen(navController: NavController) {
                   Atividades()
                }

@Composable

fun Atividades() {

    Column(
        modifier = Modifier
            .background(Color(0xFF10131B))
            .verticalScroll(ScrollState(0))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)){

            Spacer(modifier = Modifier.height(2.dp))
            Button(onClick = { /*TODO*/ },
                Modifier
                    .width(28.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10131B)),
                shape = RectangleShape
                )
                {
                Text(
                    text = "❮",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,

                )

            }
            Text(
                text = "Iniciar Atividade",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth()

            )


        }

        BotoesAtividade("Caminhada", Imagem = painterResource(id = R.drawable.caminhada), Imagem2 = painterResource(
            id = R.drawable.corrida1), Tempo = "1:45hr", Calorias = "705 Calorias" )
        BotoesAtividade("Musculação", Imagem = painterResource(id = R.drawable.musculacao), Imagem2 = painterResource(
            id = R.drawable.musculacao1), Tempo = "1:02hr", Calorias = "479 Calorias" )
        BotoesAtividade("Pedalada", Imagem = painterResource(id = R.drawable.pedalada), Imagem2 = painterResource(
            id = R.drawable.ciclismo1), Tempo = "0:40hr", Calorias = "332 Calorias" )
        BotoesAtividade("Corrida", Imagem = painterResource(id = R.drawable.corrida), Imagem2 = painterResource(
            id = R.drawable.corrida1), Tempo = "0:35hr", Calorias = "276 Calorias")
        BotoesAtividade("Escalada", Imagem = painterResource(id = R.drawable.escalada), Imagem2 = painterResource(
            id = R.drawable.escalada1), Tempo = "3:00hr", Calorias = "793 Calorias" )

        Spacer(modifier = Modifier.height(100.dp))
        }


    Column(
        Modifier
            .fillMaxSize()
            .height(85.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            Modifier
                .background(Color(0xFF10131B))
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .size(70.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0d65fb))
            ) {
                Text(
                    text = "Continuar  ➔",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 85.dp,
                            vertical = 10.dp
                        )
                )

            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AtividadesPreview(){
    Atividades()
}

@Composable
fun BotoesAtividade(Titulo: String, Imagem: Painter, Imagem2: Painter, Tempo: String, Calorias:String) {
    Spacer(modifier = Modifier.height(10.dp))
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF141A30))
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier
                    .padding(horizontal = 15.dp,)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,

                ) {
                Image(
                    painter = Imagem2,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = Titulo,
                    fontSize = 20.sp,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.relogio),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                    )

                    Text(
                        text = Tempo,
                        fontSize = 20.sp,
                        color = Color(0xFF5b6983)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.calorias),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                    )

                    Text(
                        text = Calorias,
                        fontSize = 20.sp,
                        color = Color(0xFF5b6983)
                    )}

                }
                Image(
                    painter = Imagem,
                    contentDescription = Titulo,
                    modifier = Modifier
                        .height(600.dp)
                        .width(200.dp)
                )
            }

        }
    }
