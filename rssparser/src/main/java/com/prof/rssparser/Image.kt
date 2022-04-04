package com.prof.rssparser

import java.io.Serializable

data class Image(
    val title: String?,
    val url: String?,
    val link: String?,
    val description: String?
) : Serializable {

    fun isNotEmpty(): Boolean {
        return !url.isNullOrBlank() || !link.isNullOrBlank()
    }

    internal data class Builder(
        private var title: String? = null,
        private var url: String? = null,
        private var link: String? = null,
        private var description: String? = null
    ) {
        fun title(title: String?) = apply { this.title = title }
        fun url(url: String?) = apply { this.url = url }
        fun link(link: String?) = apply { this.link = link }
        fun description(description: String?) = apply { this.description = description }
        fun build() = Image(title, url, link, description)
    }
}