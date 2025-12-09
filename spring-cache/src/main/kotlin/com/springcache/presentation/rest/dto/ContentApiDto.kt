package com.springcache.presentation.rest.dto

data class ContentCreateApiRequest(
    val writer: String? = null,
    val content: String? = null
)

data class ContentUpdateApiRequest(
    val content: String? = null
)