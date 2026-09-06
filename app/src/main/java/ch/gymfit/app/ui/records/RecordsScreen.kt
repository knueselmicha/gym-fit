package ch.gymfit.app.ui.records

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecordsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Rekorde", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Keine Rekorde vorhanden", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
