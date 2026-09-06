package ch.gymfit.app.ui.workout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

@Composable
fun WorkoutListScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Training", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn {
            item {
                Button(onClick = {}) {
                    Text("Neues Training erstellen")
                }
            }
            item {
                Text("Keine gespeicherten Trainings", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
