package ch.gymfit.app

import ch.gymfit.app.util.Converters
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class UnitTests {
    @Test
    fun testKgToLbsConversion() {
        val kg = 100.0
        val lbs = Converters.kgToLbs(kg)
        assertEquals(220.462262185, lbs, 0.0001)
    }

    @Test
    fun testEstimated1RM() {
        val est = Converters.estimated1RM(100.0, 8)
        assertEquals(100.0 * (1 + 8.0 / 30.0), est, 0.0001)
    }

    @Test
    fun testIsNewTrue1RM() {
        val current = 100.0
        val candidate = 105.0
        assertTrue(Converters.isNewTrue1RM(current, candidate, 1))
    }

    @Test
    fun testTrainingVolume() {
        val sets = listOf(Pair(100.0, 8), Pair(80.0, 5), Pair(null, 10))
        val vol = Converters.trainingVolumeKg(sets)
        assertEquals(100.0*8 + 80.0*5, vol, 0.0001)
    }
}
