package ch.gymfit.app.ui.workout

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ActiveWorkoutScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Aktives Training", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Übung 1")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {}) {
            Text("Satz hinzufügen")
        }
    }
}
