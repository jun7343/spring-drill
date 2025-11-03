package io.spring.controller

import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap

@Controller
class SseEmitterController {

    companion object {
        private val sseEmitters = ConcurrentHashMap<String, SseEmitter>()
    }

    @GetMapping("/sse")
    fun getSseEmitter(
        @RequestParam(value = "cid", required = true) cid: String
    ): ResponseEntity<SseEmitter> {
        val emitter = SseEmitter(60_000)

        emitter.onCompletion {
            sseEmitters.remove(cid)
        }
        emitter.onTimeout {
            sseEmitters.remove(cid)
        }
        emitter.onError {
            sseEmitters.remove(cid)
        }

        sseEmitters[cid] = emitter

        return ResponseEntity.ok()
            .header("Content-Type", "text/event-stream")
            .header("Cache-Control", "no-cache")
            .body(emitter)
    }

    @Scheduled(fixedRate = 2000)
    fun sendData() {
        sseEmitters.forEach { (cid, emitter) ->
            try {
                emitter.send(SseEmitter.event().name("message").data("Hello, $cid! timestamp: ${System.currentTimeMillis()}"))
            } catch (e: Exception) {
                sseEmitters.remove(cid)
            }
        }
    }
}