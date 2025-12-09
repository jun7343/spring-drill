package com.springcache.application.service

import com.springcache.application.service.dto.ContentDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContentService(
    private val repository: ContentRepository
) {

    fun findContent(id: UUID): ContentDto {
        val content = repository.findContent(id)

        return ContentDto(
            id = content.id!!,
            content = content.content ?: "",
            writer = content.writer ?: ""
        )
    }

    fun createContent(writer: String, content: String) {
        repository.save(writer, content)
    }

    fun updateContent(id: UUID, content: String) {
        repository.updateContent(id, content)
    }
}