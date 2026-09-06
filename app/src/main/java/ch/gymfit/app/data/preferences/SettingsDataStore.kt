package ch.gymfit.app.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("gymfit_prefs")

class SettingsDataStore(private val context: Context) {
    companion object {
        val UNIT_IS_KG = booleanPreferencesKey("unit_is_kg")
        val TIMER_DEFAULT = intPreferencesKey("timer_default")
        val TIMER_AUTOSTART = booleanPreferencesKey("timer_autostart")
        val TIMER_VIBRATE = booleanPreferencesKey("timer_vibrate")
        val TIMER_NOTIFY = booleanPreferencesKey("timer_notify")
        val CONFIRM_DELETE = booleanPreferencesKey("confirm_delete")
        val TIMER_END_TIMESTAMP = longPreferencesKey("timer_end_timestamp")
    }

    val prefsFlow: Flow<Map<String, Any>> = context.dataStore.data.map { prefs ->
        prefs.asMap().mapKeys { it.key.name }.mapValues { it.value as Any }
    }

    suspend fun setDefaultTimer(seconds: Int) {
        context.dataStore.edit { prefs ->
            prefs[TIMER_DEFAULT] = seconds
        }
    }

    suspend fun setAutostart(enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[TIMER_AUTOSTART] = enabled
        }
    }

    suspend fun setTimerEndTimestamp(endMs: Long?) {
        context.dataStore.edit { prefs ->
            if (endMs == null) prefs.remove(TIMER_END_TIMESTAMP) else prefs[TIMER_END_TIMESTAMP] = endMs
        }
    }

    fun getDefaultTimerFlow() = context.dataStore.data.map { it[TIMER_DEFAULT] ?: 60 }
    fun getAutostartFlow() = context.dataStore.data.map { it[TIMER_AUTOSTART] ?: false }
    fun getVibrateFlow() = context.dataStore.data.map { it[TIMER_VIBRATE] ?: true }
    fun getNotifyFlow() = context.dataStore.data.map { it[TIMER_NOTIFY] ?: false }
    fun getConfirmDeleteFlow() = context.dataStore.data.map { it[CONFIRM_DELETE] ?: true }
    fun getTimerEndTimestampFlow() = context.dataStore.data.map { it[TIMER_END_TIMESTAMP] ?: 0L }
}
