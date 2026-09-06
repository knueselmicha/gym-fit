package ch.gymfit.app.data.local.seed

import ch.gymfit.app.data.local.entity.ExerciseEntity
import java.util.*

object ExerciseSeed {
    fun defaultExercises(): List<ExerciseEntity> {
        fun id(s: String) = UUID.nameUUIDFromBytes(s.toByteArray()).toString()
        val list = mutableListOf<ExerciseEntity>()

        // Brust
        list += ExerciseEntity(id("Bankdruecken_Langhantel"), "Bankdrücken mit Langhantel", "Barbell Bench Press", "Brust", "Trizeps", "Kraft", false)
        list += ExerciseEntity(id("Schraegbank_Langhantel"), "Schrägbankdrücken mit Langhantel", "Incline Barbell Bench Press", "Brust", "Schultern", "Kraft", false)
        list += ExerciseEntity(id("Kurzhantel_Bankdruecken"), "Kurzhantel-Bankdrücken", "Dumbbell Bench Press", "Brust", "Trizeps", "Kraft", false)
        list += ExerciseEntity(id("Liegestuetze"), "Liegestütze", "Push-ups", "Brust", null, "Körpergewicht", false)
        list += ExerciseEntity(id("Dips_Brust"), "Dips mit Brustfokus", "Dips (Chest)", "Brust", "Trizeps", "Körpergewicht", false)
        // Rücken
        list += ExerciseEntity(id("Klimmzuege"), "Klimmzüge", "Pull-ups", "Rücken", "Bizeps", "Körpergewicht", false)
        list += ExerciseEntity(id("Kreuzheben"), "Kreuzheben", "Deadlift", "Rücken", "Beine", "Kraft", false)
        list += ExerciseEntity(id("Langhantelrudern"), "Langhantelrudern", "Barbell Row", "Rücken", "Bizeps", "Kraft", false)
        // Schultern
        list += ExerciseEntity(id("Schulterdruecken_Lang"), "Schulterdrücken mit Langhantel", "Barbell Shoulder Press", "Schultern", "Trizeps", "Kraft", false)
        list += ExerciseEntity(id("Seitheben"), "Seitheben mit Kurzhanteln", "Dumbbell Lateral Raise", "Schultern", null, "Isolations", false)
        // Bizeps
        list += ExerciseEntity(id("Langhantel_Curls"), "Langhantel-Curls", "Barbell Curls", "Bizeps", null, "Isolations", false)
        // Trizeps
        list += ExerciseEntity(id("Trizepsdruecken_Kabel"), "Trizepsdrücken am Kabel", "Cable Triceps Pushdown", "Trizeps", null, "Isolations", false)
        // Beine
        list += ExerciseEntity(id("Kniebeugen"), "Kniebeugen", "Squats", "Quadrizeps", "Gesäss", "Kraft", false)
        list += ExerciseEntity(id("Beinpresse"), "Beinpresse", "Leg Press", "Quadrizeps", "Gesäss", "Maschine", false)
        list += ExerciseEntity(id("Rum_Kreuzheben"), "Rumänisches Kreuzheben", "Romanian Deadlift", "Beinbeuger", "Gesäss", "Kraft", false)
        // Waden
        list += ExerciseEntity(id("Wadenheben_Stehend"), "Wadenheben stehend", "Standing Calf Raise", "Waden", null, "Isolations", false)
        // Bauch
        list += ExerciseEntity(id("Crunches"), "Crunches", "Crunches", "Bauch", null, "Körpergewicht", false)
        // Ganzkörper
        list += ExerciseEntity(id("Clean_and_Press"), "Clean and Press", "Clean and Press", "Ganzkörper", null, "Kraft", false)

        // ... (weitere Übungen können hier ergänzt werden; die Liste ist idempotent)
        return list
    }
}
