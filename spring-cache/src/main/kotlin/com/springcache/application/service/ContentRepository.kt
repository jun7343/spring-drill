package com.springcache.application.service

import com.springcache.infrastructure.persistence.entity.JpaEntityContent
import java.util.*

interface ContentRepository {
    fun findContent(id: UUID): JpaEntityContent
    fun save(writer: String, content: String)
    fun updateContent(id: UUID, content: String)
}
