package com.kmp.example.shared.domain.config

class GetUrlUseCase(
    private val provider: UrlProvider
) {
    fun execute(): String = provider.getUrl()
}
