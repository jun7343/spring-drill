package com.springcache.presentation.rest

import com.springcache.application.service.ContentService
import com.springcache.application.service.dto.ContentDto
import com.springcache.presentation.rest.dto.ContentCreateApiRequest
import com.springcache.presentation.rest.dto.ContentUpdateApiRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
class ContentRestController(
    private val contentService: ContentService
) {

    @GetMapping("/api/content/{id}")
    fun getContent(
        @PathVariable id: UUID
    ): ResponseEntity<ContentDto> {

        return ResponseEntity.ok(null)
    }

    @PostMapping("/api/content")
    fun postContent(
        request: ContentCreateApiRequest
    ): ResponseEntity<String> {
        contentService.createContent(
            writer = request.writer ?: throw RuntimeException("Writer must not be null"),
            content = request.content ?: throw RuntimeException("Content must not be null"),
        )

        return ResponseEntity.ok("Success")
    }

    @PutMapping("/api/content/{id}")
    fun putContent(
        @PathVariable("id") id: UUID,
        @RequestBody request: ContentUpdateApiRequest
    ): ResponseEntity<String> {
        contentService.updateContent(
            id = id,
            content = request.content ?: throw RuntimeException("Content must not be null"),
        )

        return ResponseEntity.ok("Success")
    }
}