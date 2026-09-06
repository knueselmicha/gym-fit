package ch.gymfit.app.data.repository

import android.content.Context
import ch.gymfit.app.data.local.dao.ExerciseDao
import ch.gymfit.app.data.local.dao.RecordDao
import ch.gymfit.app.data.local.dao.WorkoutDao
import ch.gymfit.app.data.local.database.AppDatabase
import ch.gymfit.app.data.local.entity.*
import ch.gymfit.app.data.local.seed.ExerciseSeed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.util.*

class GymRepository(private val db: AppDatabase) {

    private val exerciseDao: ExerciseDao = db.exerciseDao()
    private val workoutDao: WorkoutDao = db.workoutDao()
    private val recordDao: RecordDao = db.recordDao()

    suspend fun seedIfNeeded() {
        // Insert seed exercises idempotent (INSERT IGNORE behaviour)
        val seed = ExerciseSeed.defaultExercises()
        exerciseDao.insertAll(seed)
    }

    fun exercises(): Flow<List<ExerciseEntity>> = exerciseDao.getAll()

    suspend fun addCustomExercise(entity: ExerciseEntity) {
        exerciseDao.upsert(entity)
    }

    suspend fun upsertWorkout(workout: WorkoutEntity, exercises: List<WorkoutExerciseEntity>, sets: List<WorkoutSetEntity>) {
        db.runInTransaction {
            workoutDao.insertFull(workout, exercises, sets)
        }
    }

    suspend fun getAllWorkouts(): List<WorkoutEntity> = workoutDao.getAllWorkouts()

    suspend fun savePR(pr: PersonalRecordEntity) {
        recordDao.upsert(pr)
        recordDao.insertHistory(PRHistoryEntity(UUID.randomUUID().toString(), pr.exerciseId, pr.weightKg, pr.reps, pr.timestamp, pr.note))
    }

    fun prs(): Flow<List<PersonalRecordEntity>> = recordDao.getAll()

    fun prHistory(exerciseId: String): Flow<List<PRHistoryEntity>> = recordDao.historyFor(exerciseId)
}
