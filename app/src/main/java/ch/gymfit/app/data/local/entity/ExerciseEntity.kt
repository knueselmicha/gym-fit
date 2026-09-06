package ch.gymfit.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey val id: String,
    val name_de: String,
    val name_en: String? = null,
    val primary_muscle: String,
    val secondary_muscles: String? = null,
    val type: String? = null,
    val is_custom: Boolean = false,
    val description: String? = null,
    val deleted: Boolean = false
)
