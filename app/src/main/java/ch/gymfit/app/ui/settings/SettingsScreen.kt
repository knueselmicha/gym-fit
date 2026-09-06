package ch.gymfit.app.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Einstellungen", style = androidx.compose.material3.MaterialTheme.typography.headlineSmall, color = androidx.compose.material3.MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Timer automatisch starten")
            var checked by remember { mutableStateOf(false) }
            Switch(checked = checked, onCheckedChange = { checked = it })
        }
    }
}
