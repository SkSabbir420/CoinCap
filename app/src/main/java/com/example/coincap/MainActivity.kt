package com.example.coincap

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coincap.coin_cap_feature.presentation.Screen
import com.example.coincap.coin_cap_feature.presentation.coin_detail.CoinDetailScreen
import com.example.coincap.coin_cap_feature.presentation.coin_detail.CoinDetailViewModel
import com.example.coincap.ui.theme.CoinCapTheme
import com.example.coincap.coin_cap_feature.presentation.coin_list.CoinListScreen
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<CoinListViewModel>()
            val viewModelDetailScreen = hiltViewModel<CoinDetailViewModel>()

            CoinCapTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController,viewModel)
                        }

//                        composable(
//                            route = Screen.CoinDetailScreen.route + "/{id}"
//                        ) {
//                            CoinDetailScreen(viewModelDetailScreen)
//                        }

                        composable(
                            route = Screen.CoinDetailScreen.route + "/{id}",
                            arguments = listOf(navArgument("id"){
                                type = NavType.StringType
                            })
                        ) { backStrackEntry ->
                            val id = requireNotNull( backStrackEntry.arguments).getString("id")
                            Log.d("Debugging","Pass coin id pass into coindetailscreen: ${id.toString()}")
                            //How to pass id into viewmodel?
                            CoinDetailScreen(viewModelDetailScreen)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoinCapTheme {
        Greeting("Android")
    }
}