package ch.gymfit.app.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ch.gymfit.app.ui.dashboard.DashboardScreen
import ch.gymfit.app.ui.exercise.ExercisePickerScreen
import ch.gymfit.app.ui.history.HistoryScreen
import ch.gymfit.app.ui.records.RecordsScreen
import ch.gymfit.app.ui.settings.SettingsScreen
import ch.gymfit.app.ui.workout.WorkoutListScreen

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object Workouts : Screen("workouts")
    object Records : Screen("records")
    object History : Screen("history")
    object ExercisePicker : Screen("exercise_picker")
    object Settings : Screen("settings")
}

@Composable
fun NavGraph(navController: NavHostController, padding: PaddingValues) {
    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }
        composable(Screen.Workouts.route) {
            WorkoutListScreen()
        }
        composable(Screen.Records.route) {
            RecordsScreen()
        }
        composable(Screen.History.route) {
            HistoryScreen()
        }
        composable(Screen.ExercisePicker.route) {
            ExercisePickerScreen()
        }
        composable(Screen.Settings.route) {
            SettingsScreen()
        }
    }
}
