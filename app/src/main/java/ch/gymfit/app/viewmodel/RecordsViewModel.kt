package ch.gymfit.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ch.gymfit.app.data.local.database.AppDatabase
import ch.gymfit.app.data.repository.GymRepository

class RecordsViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.get(application)
    private val repo = GymRepository(db)

    val prs = repo.prs()
}
