package org.standardj.rine.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.standardj.rine.database.FriendRepository
import java.lang.IllegalArgumentException

class HomeViewModelFactory(private val repository: FriendRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}