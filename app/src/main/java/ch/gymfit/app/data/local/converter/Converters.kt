package ch.gymfit.app.data.local.converter

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromList(value: List<String>?): String? = value?.joinToString(separator = "||")
    @TypeConverter
    fun toList(value: String?): List<String> = value?.split("||")?.filter { it.isNotEmpty() } ?: emptyList()
}
