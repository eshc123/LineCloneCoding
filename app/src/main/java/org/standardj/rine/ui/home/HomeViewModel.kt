package org.standardj.rine.ui.home

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.standardj.rine.database.Friend
import org.standardj.rine.database.FriendRepository

class HomeViewModel(private val repository: FriendRepository) : ViewModel() {

    val allFriends : LiveData<List<Friend>> = repository.allFriends.asLiveData()

    fun insert(friend: Friend) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(friend)
    }

}