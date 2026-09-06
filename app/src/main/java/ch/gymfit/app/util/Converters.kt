package ch.gymfit.app.util

object Converters {
    fun kgToLbs(kg: Double): Double = kg * 2.20462262185
    fun lbsToKg(lbs: Double): Double = lbs / 2.20462262185

    fun estimated1RM(weightKg: Double, reps: Int): Double {
        // Epley
        return weightKg * (1.0 + reps / 30.0)
    }

    fun isNewTrue1RM(currentPrKg: Double?, candidateWeightKg: Double, candidateReps: Int): Boolean {
        if (candidateReps != 1) return false
        return (currentPrKg ?: 0.0) < candidateWeightKg
    }

    fun trainingVolumeKg(sets: List<Pair<Double?, Int?>>): Double {
        var sum = 0.0
        for (s in sets) {
            val w = s.first
            val r = s.second
            if (w != null && r != null) {
                sum += w * r
            }
        }
        return sum
    }
}
