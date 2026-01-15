package com.kmp.example.shared.domain.usecase

import com.kmp.example.shared.core.constants.WebViewConstants

class GetUrlUseCase {
    fun execute(): String = WebViewConstants.DEFAULT_URL
}
