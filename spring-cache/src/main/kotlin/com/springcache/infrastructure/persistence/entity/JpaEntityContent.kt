package com.springcache.infrastructure.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "content")
class JpaEntityContent(
    @Id
    val id: UUID? = UUID.randomUUID()
) {

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    var content: String? = null

    @Column(name = "writer", nullable = false)
    var writer: String? = null
}