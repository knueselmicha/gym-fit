package ch.gymfit.app.ui.history

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HistoryScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Verlauf", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Noch keine Trainings gespeichert", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
