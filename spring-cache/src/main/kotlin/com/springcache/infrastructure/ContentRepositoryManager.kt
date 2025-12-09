package com.springcache.infrastructure

import com.springcache.application.service.ContentRepository
import com.springcache.infrastructure.persistence.entity.JpaEntityContent
import com.springcache.infrastructure.persistence.repository.ContentJpaRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Component
class ContentRepositoryManager(
    private val jpaRepository: ContentJpaRepository
): ContentRepository {

    @Transactional(readOnly = true)
    override fun findContent(id: UUID): JpaEntityContent {
        return findById(id)
    }

    override fun save(writer: String, content: String) {
        val jpaEntityContent = JpaEntityContent().apply {
            this.writer = writer
            this.content = content
        }

        jpaRepository.save(jpaEntityContent)
    }

    @Transactional
    override fun updateContent(id: UUID, content: String) {
        val entity = findById(id)

        entity.content = content
    }

    private fun findById(id: UUID): JpaEntityContent {
        return jpaRepository.findById(id).getOrNull() ?: RuntimeException("Content not found for id: $id").let { throw it }
    }
}