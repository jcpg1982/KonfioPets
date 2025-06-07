package pe.com.master.machines.konfiopets.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import pe.com.master.machines.design.theme.KonfioPetsTheme
import pe.com.master.machines.home.route.HomeRoute
import pe.com.master.machines.konfiopets.ui.navigation.NavigationWrapper

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KonfioPetsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationWrapper(
                        startDestination = HomeRoute,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KonfioPetsTheme {
        NavigationWrapper(
            startDestination = HomeRoute,
            modifier = Modifier.fillMaxSize()
        )
    }
}