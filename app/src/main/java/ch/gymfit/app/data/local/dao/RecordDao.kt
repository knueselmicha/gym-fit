package ch.gymfit.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ch.gymfit.app.data.local.entity.PersonalRecordEntity
import ch.gymfit.app.data.local.entity.PRHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {
    @Query("SELECT * FROM personal_records ORDER BY timestamp DESC")
    fun getAll(): Flow<List<PersonalRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(pr: PersonalRecordEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(history: PRHistoryEntity)

    @Query("SELECT * FROM pr_history WHERE exerciseId = :exerciseId ORDER BY timestamp DESC")
    fun historyFor(exerciseId: String): Flow<List<PRHistoryEntity>>
}
