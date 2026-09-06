package ch.gymfit.app

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import ch.gymfit.app.ui.navigation.NavGraph
import ch.gymfit.app.ui.components.BottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GymFitApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        NavGraph(navController = navController, padding = innerPadding)
    }
}
