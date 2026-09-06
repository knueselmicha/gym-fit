package ch.gymfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "workout_sets",
    foreignKeys = [
        ForeignKey(entity = WorkoutExerciseEntity::class, parentColumns = ["id"], childColumns = ["workoutExerciseId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("workoutExerciseId")]
)
data class WorkoutSetEntity(
    @PrimaryKey val id: String,
    val workoutExerciseId: String,
    val setNumber: Int,
    val weightKg: Double?,
    val reps: Int?,
    val rir: Int?,
    val isWarmup: Boolean = false,
    val completed: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)
