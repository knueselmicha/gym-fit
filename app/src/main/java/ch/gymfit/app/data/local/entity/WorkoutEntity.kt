package ch.gymfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workouts")
data class WorkoutEntity(
    @PrimaryKey val id: String,
    val name: String,
    val start_time: Long,
    val end_time: Long? = null,
    val note: String? = null,
    val is_completed: Boolean = false
)
