package br.com.fiap.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {

    // Variáveis de estado
    var email by remember() { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var tamanhoSenha = 8 // Tamanho mínimo da senha

    // Composição da tela de login
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.login), // Texto do arquivo strings.xml
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Text(text = stringResource(id = R.string.subtitle),)
        Spacer(
            modifier = Modifier
                .height(48.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(stringResource(id = R.string.email)) // Texto do arquivo strings.xml
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                )
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        if (it.length <= tamanhoSenha) password = it}, // Verifica se a senha tem o tamanho mínimo
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(text = stringResource(id = R.string.password)) // Texto do arquivo strings.xml
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text(
                        text = stringResource(id = R.string.enter), // Texto do arquivo strings.xml
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}