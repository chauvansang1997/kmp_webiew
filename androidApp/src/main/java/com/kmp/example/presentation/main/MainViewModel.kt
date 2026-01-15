package com.kmp.example.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.example.shared.data.result.Result
import com.kmp.example.shared.domain.usecase.GetTodoTitleUseCase
import com.kmp.example.shared.domain.config.GetUrlUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUrlUseCase: GetUrlUseCase,
    private val getTodoTitleUseCase: GetTodoTitleUseCase
) : ViewModel() {

    private val _toastMessage = MutableStateFlow<String?>(null)
    private val _isLoading = MutableStateFlow(false)

    val webViewUrl: String = getUrlUseCase.execute()
    val toastMessage: StateFlow<String?> = _toastMessage.asStateFlow()
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadTodoTitle() {
        viewModelScope.launch {
            _isLoading.value = true

            when (val result = getTodoTitleUseCase.execute()) {
                is Result.Success -> {
                    _toastMessage.value = result.data
                }
                is Result.Error -> {
                    _toastMessage.value = result.message ?: "Unable to load title"
                }
            }

            _isLoading.value = false
        }
    }

    fun clearToastMessage() {
        _toastMessage.value = null
    }
}
