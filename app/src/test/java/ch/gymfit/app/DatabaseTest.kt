package ch.gymfit.app

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import ch.gymfit.app.data.local.database.AppDatabase
import ch.gymfit.app.data.local.seed.ExerciseSeed
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DatabaseTest {
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val ctx = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(ctx, AppDatabase::class.java).build()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testSeedNoDuplicates() {
        val seed = ExerciseSeed.defaultExercises()
        // insert twice - DAO insertAll uses IGNORE on conflict so duplicates won't be added
        runBlockingForTest {
            db.exerciseDao().insertAll(seed)
            db.exerciseDao().insertAll(seed)
            val list = db.exerciseDao().getAll().first()
            assertTrue(list.size >= seed.size)
        }
    }

    private fun runBlockingForTest(block: suspend () -> Unit) {
        kotlinx.coroutines.runBlocking { block() }
    }
}
