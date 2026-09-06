package ch.gymfit.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ch.gymfit.app.ui.navigation.Screen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.History

@Composable
fun SmallCard(modifier: Modifier = Modifier, title: String, content: @Composable () -> Unit) {
    Card(modifier = modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), shape = RoundedCornerShape(16.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate(Screen.Dashboard.route) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Übersicht") },
            label = { Text("Übersicht") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(Screen.Workouts.route) },
            icon = { Icon(Icons.Default.FitnessCenter, contentDescription = "Training") },
            label = { Text("Training") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(Screen.Records.route) },
            icon = { Icon(Icons.Default.List, contentDescription = "Rekorde") },
            label = { Text("Rekorde") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(Screen.History.route) },
            icon = { Icon(Icons.Default.History, contentDescription = "Verlauf") },
            label = { Text("Verlauf") }
        )
    }
}
