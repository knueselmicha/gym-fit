package ch.gymfit.app.ui.exercise

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExercisePickerScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Übung auswählen", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn {
            item { Text("Bankdrücken mit Langhantel") }
            item { Text("Klimmzüge") }
            item { Text("Kniebeugen") }
        }
    }
}
