package com.example.cardinfofinder.ui.info_finder.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardinfofinder.data.common.Result
import com.example.cardinfofinder.data.models.info_finder.CardInfoResponse
import com.example.cardinfofinder.ui.info_finder.repositories.InfoFinderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class InputCardDetailsViewModel @Inject constructor(
    var infoFinderRepository: InfoFinderRepository
) : ViewModel() {

    private var _information = MutableLiveData<Result<CardInfoResponse>>()
    val information: LiveData<Result<CardInfoResponse>>
        get() = _information

    fun lookup(bin: String) {
        _information.postValue(Result.Loading())
        viewModelScope.launch {
            try {
                val infoResponse = infoFinderRepository.lookupBIN(bin)
                _information.postValue(Result.Success(infoResponse))
            } catch(ex: Exception) {
                _information.postValue(Result.Error(ex.message!!))
            }
        }
    }

}