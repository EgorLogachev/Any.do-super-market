package com.example.superdomarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.superdomarket.ui.products_list.ProductsList
import com.example.superdomarket.ui.theme.SuperdoMarketTheme
import dagger.hilt.android.AndroidEntryPoint


/// todo add app title
/// todo add connection/disconnection button
@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperdoMarketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //todo receive list of products here
                    ProductsList() { color ->
                        //todo open color screen
                    }
                }
            }
        }
    }



//    fun asdfadsf() {
//        webSocket.close()
//    }

//    1000 - NORMAL_CLOSURE_STATUS
//    1001 - going away
//    1002 - termination due error


}

