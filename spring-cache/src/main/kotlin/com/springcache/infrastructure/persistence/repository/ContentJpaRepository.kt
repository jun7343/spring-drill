package com.springcache.infrastructure.persistence.repository

import com.springcache.infrastructure.persistence.entity.JpaEntityContent
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ContentJpaRepository: JpaRepository<JpaEntityContent, UUID> {
}