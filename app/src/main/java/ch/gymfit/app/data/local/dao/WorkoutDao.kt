package ch.gymfit.app.data.local.dao

import androidx.room.*
import ch.gymfit.app.data.local.entity.WorkoutEntity
import ch.gymfit.app.data.local.entity.WorkoutExerciseEntity
import ch.gymfit.app.data.local.entity.WorkoutSetEntity

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: WorkoutEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercises(exercises: List<WorkoutExerciseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSets(sets: List<WorkoutSetEntity>)

    @Transaction
    suspend fun insertFull(workout: WorkoutEntity, exercises: List<WorkoutExerciseEntity>, sets: List<WorkoutSetEntity>) {
        insertWorkout(workout)
        insertExercises(exercises)
        insertSets(sets)
    }

    @Query("SELECT * FROM workouts ORDER BY start_time DESC")
    suspend fun getAllWorkouts(): List<WorkoutEntity>

    @Query("SELECT * FROM workouts WHERE id = :id LIMIT 1")
    suspend fun findWorkout(id: String): WorkoutEntity?

    @Query("DELETE FROM workouts WHERE id = :id")
    suspend fun deleteWorkout(id: String)
}
