package ch.gymfit.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import ch.gymfit.app.data.local.database.AppDatabase
import ch.gymfit.app.data.repository.GymRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.get(application)
    private val repo = GymRepository(db)

    val newWorkoutName = MutableStateFlow("")
    val selectedExercises = MutableStateFlow<List<String>>(emptyList())

    val saving = MutableStateFlow(false)

    fun createWorkout(nowMs: Long = System.currentTimeMillis()) {
        val name = newWorkoutName.value.ifBlank { "Training ${Date(nowMs)}" }
        val wid = UUID.randomUUID().toString()
        val workoutEntity = ch.gymfit.app.data.local.entity.WorkoutEntity(wid, name, nowMs)
        viewModelScope.launch {
            saving.value = true
            repo.upsertWorkout(workoutEntity, emptyList(), emptyList())
            saving.value = false
        }
    }
}
