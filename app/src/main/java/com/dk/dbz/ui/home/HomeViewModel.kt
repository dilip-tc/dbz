package com.dk.dbz.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dk.dbz.data.api.ZCharacterApi
import com.dk.dbz.data.api.model.ZCharacter
import com.dk.dbz.di.ZCharacterApiModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class HomeViewModel : ViewModel(){
    private val _state = MutableStateFlow(emptyList<ZCharacter>())
    val state :StateFlow<List<ZCharacter>>
        get() = _state

    init {
        viewModelScope.launch {
            val retrofitProvider =ZCharacterApiModule.provideRetrofit()
            _state.value = retrofitProvider.getZCharacter()
//            val s = retrofitProvider.getZgh()
        }
    }
}