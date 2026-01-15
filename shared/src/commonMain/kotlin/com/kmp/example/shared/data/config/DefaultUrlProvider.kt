package com.kmp.example.shared.data.config

import com.kmp.example.shared.core.constants.WebViewConstants
import com.kmp.example.shared.domain.config.UrlProvider

class DefaultUrlProvider : UrlProvider {
    override fun getUrl(): String = WebViewConstants.DEFAULT_URL
}
