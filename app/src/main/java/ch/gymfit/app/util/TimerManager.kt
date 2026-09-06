package ch.gymfit.app.util

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.math.max

/**
 * Ein kleiner Timer-Manager, der den Endzeitpunkt persistent in DataStore (über SettingsDataStore)
 * speichern kann (SettingsDataStore wird in ViewModels verwendet).
 * Hier vereinfachend: lokaler In-Memory Manager, Endzeit wird vom ViewModel/Datastore gesetzt.
 */

class TimerManager {
    private val _remaining = MutableStateFlow(0L)
    val remaining: StateFlow<Long> = _remaining.asStateFlow()

    private var endTimestamp: Long = 0L
    private var running = false

    private val scope = CoroutineScope(Dispatchers.Main)

    fun startForSeconds(seconds: Int, endAtMs: Long? = null) {
        val now = System.currentTimeMillis()
        endTimestamp = endAtMs ?: (now + seconds * 1000L)
        running = true
        updateLoop()
    }

    fun pause() {
        if (!running) return
        running = false
    }

    fun reset() {
        running = false
        endTimestamp = 0L
        _remaining.value = 0L
    }

    private fun updateLoop() {
        scope.launch {
            while (running) {
                val now = System.currentTimeMillis()
                val rem = max(0L, endTimestamp - now)
                _remaining.value = rem
                if (rem <= 0L) {
                    running = false
                    break
                }
                kotlinx.coroutines.delay(250)
            }
        }
    }

    fun isRunning() = running
}
