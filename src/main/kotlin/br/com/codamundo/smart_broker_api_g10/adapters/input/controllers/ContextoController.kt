package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated


@RestController
@RequestMapping("/api/contextos")
class ContextoController(private val contextoInput: ContextoInput) {

    @GetMapping("/{id}")
    fun getContexto(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?
    ): ResponseEntity<ContextoResponse> {
        val contexto = contextoInput.getContexto(id)
        return ResponseEntity.ok(contexto)
    }

    @PostMapping
    fun createContexto(
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated contextoRequest: ContextoRequest
    ): ResponseEntity<ContextoResponse> {
        val novoContexto = contextoInput.createContexto(contextoRequest)
        return ResponseEntity.status(201).body(novoContexto)
    }

    @PatchMapping("/{id}")
    fun updateContexto(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated contextoRequest: ContextoRequest
    ): ResponseEntity<Void> {
        contextoInput.updateContexto(id, contextoRequest)
        return ResponseEntity.noContent().build()
    }
}
