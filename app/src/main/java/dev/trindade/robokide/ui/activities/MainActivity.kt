package dev.trindade.robokide.ui.activities

import android.os.Bundle

import androidx.activity.*
import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.draw.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.foundation.*
import androidx.compose.ui.graphics.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*

import dev.trindade.robokide.ui.theme.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobokTheme {
                Scaffold(
                    modifier = 
                      Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    content()
                }
            }
        }
    }
    
    @Composable
    fun Content () {
        codeTextField()
    }
    
    @Composable
    fun codeTextField () {
        var code by remember {
             mutableStateOf(TextFieldValue(""))
        }
        TextField (
            value = code,
            onValueChange = {
                code = it
            },
            label = {
                Text(
                    text = "Code"
                )
            }        
        )        
    }
    
}