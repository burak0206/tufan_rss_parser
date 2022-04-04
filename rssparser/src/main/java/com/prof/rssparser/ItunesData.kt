package com.prof.rssparser

import java.io.Serializable

data class ItunesArticleData(
    val author: String?,
    val duration: String?,
    val episode: String?,
    val episodeType: String?,
    val explicit: String?,
    val image: String?,
    val keywords: List<String>,
    val subtitle: String?,
    val summary: String?,
) : Serializable {
    internal data class Builder(
        private var author: String? = null,
        private var duration: String? = null,
        private var episode: String? = null,
        private var episodeType: String? = null,
        private var explicit: String? = null,
        private var image: String? = null,
        private var keywords: List<String> = emptyList(),
        private var subtitle: String? = null,
        private var summary: String? = null,
    ) {
        fun image(image: String?) = apply { this.image = image }
        fun duration(duration: String?) = apply { this.duration = duration }
        fun explicit(explicit: String?) = apply { this.explicit = explicit }
        fun keywords(keywords: List<String>) = apply { this.keywords = keywords }
        fun subtitle(subtitle: String?) = apply { this.subtitle = subtitle }
        fun episode(episode: String?) = apply { this.episode = episode }
        fun episodeType(episodeType: String?) = apply { this.episodeType = episodeType }
        fun author(author: String?) = apply { this.author = author }
        fun summary(summary: String?) = apply { this.summary = summary }
        fun build() = ItunesArticleData(
            author,
            duration,
            episode,
            episodeType,
            explicit,
            image,
            keywords,
            subtitle,
            summary
        )
    }

}

data class ItunesChannelData(
    val author: String?,
    val categories: List<String> = emptyList(),
    val duration: String?,
    val explicit: String?,
    val image: String?,
    val keywords: List<String>,
    val newsFeedUrl: String?,
    val owner: ItunesOwner?,
    val subtitle: String?,
    val summary: String?,
    val type: String?,
) : Serializable {
    internal data class Builder(
        private var author: String? = null,
        private var categories: MutableList<String> = mutableListOf(),
        private var duration: String? = null,
        private var explicit: String? = null,
        private var image: String? = null,
        private var keywords: List<String> = emptyList(),
        private var newsFeedUrl: String? = null,
        private var owner: ItunesOwner? = null,
        private var subtitle: String? = null,
        private var summary: String? = null,
        private var type: String? = null,

        ) {
        fun explicit(explicit: String?) = apply { this.explicit = explicit }
        fun type(type: String?) = apply { this.type = type }
        fun subtitle(subtitle: String?) = apply { this.subtitle = subtitle }
        fun author(author: String?) = apply { this.author = author }
        fun summary(summary: String?) = apply { this.summary = summary }
        fun image(image: String?) = apply { this.image = image }
        fun addCategory(category: String?) = apply {
            if (!category.isNullOrEmpty()) {
                categories.add(category)
            }
        }

        fun newsFeedUrl(newsFeedUrl: String?) = apply { this.newsFeedUrl = newsFeedUrl }
        fun owner(owner: ItunesOwner?) = apply { this.owner = owner }
        fun duration(duration: String?) = apply { this.duration = duration }
        fun keywords(keywords: List<String>) = apply { this.keywords = keywords }
        fun build() = ItunesChannelData(
            author,
            categories,
            duration,
            explicit,
            image,
            keywords,
            newsFeedUrl,
            owner,
            subtitle,
            summary,
            type
        )
    }
}

data class ItunesOwner(
    val name: String?,
    val email: String?,
) : Serializable {
    internal data class Builder(
        private var name: String? = null,
        private var email: String? = null,
    ) {
        fun name(name: String?) = apply { this.name = name }
        fun email(email: String?) = apply { this.email = email }
        fun build() = ItunesOwner(name, email)
    }
}