package ch.gymfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personal_records")
data class PersonalRecordEntity(
    @PrimaryKey val id: String,
    val exerciseId: String,
    val weightKg: Double,
    val reps: Int = 1,
    val timestamp: Long = System.currentTimeMillis(),
    val note: String? = null
)
