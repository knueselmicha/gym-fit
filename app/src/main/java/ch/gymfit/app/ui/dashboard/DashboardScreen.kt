package ch.gymfit.app.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.gymfit.app.ui.components.SmallCard
import androidx.compose.material3.Text

@Composable
fun DashboardScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Gym-Fit", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(12.dp))
        SmallCard(title = "Start") {
            Button(onClick = { /* Navigation handled by NavController in NavGraph */ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Training starten")
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        SmallCard(title = "Letztes Training") {
            Text(text = "Kein letztes Training", color = MaterialTheme.colorScheme.onSurface)
        }
    }
}
