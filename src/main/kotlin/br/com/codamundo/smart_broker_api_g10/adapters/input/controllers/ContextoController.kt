package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

import br.com.codamundo.smart_broker_api_g10.application.ports.input.ContextoInput
import br.com.codamundo.smart_broker_api_g10.shared.dto.ContextoRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.ContextoResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/contextos")
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
        @RequestBody @Validated contextoRequestBodyDto: ContextoRequestBodyDto
    ): ResponseEntity<ContextoResponse> {
        val novoContexto = contextoInput.createContexto(contextoRequestBodyDto)
        return ResponseEntity.status(201).body(novoContexto)
    }

    @PatchMapping("/{id}")
    fun updateContexto(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated contextoRequestBodyDto: ContextoRequestBodyDto
    ): ResponseEntity<Void> {
        contextoInput.updateContexto(id, contextoRequestBodyDto)
        return ResponseEntity.noContent().build()
    }
}
