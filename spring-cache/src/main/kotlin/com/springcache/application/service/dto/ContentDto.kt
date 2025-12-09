package com.springcache.application.service.dto

import java.util.*

data class ContentDto(
    val id: UUID,
    val writer: String,
    val content: String
)