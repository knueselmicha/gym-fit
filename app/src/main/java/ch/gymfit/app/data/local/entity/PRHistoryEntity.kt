package ch.gymfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pr_history")
data class PRHistoryEntity(
    @PrimaryKey val id: String,
    val exerciseId: String,
    val weightKg: Double,
    val reps: Int,
    val timestamp: Long = System.currentTimeMillis(),
    val note: String? = null
)
