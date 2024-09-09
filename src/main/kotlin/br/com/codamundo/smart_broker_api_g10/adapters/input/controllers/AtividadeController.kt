package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated

@RestController
@RequestMapping("/api/atividades")
class AtividadeController(private val atividadeInput: AtividadeInput) {

    @GetMapping("/{id}")
    fun getAtividade(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?
    ): ResponseEntity<AtividadeResponse> {
        val atividade = atividadeInput.getAtividade(id)
        return ResponseEntity.ok(atividade)
    }

    @PostMapping
    fun createAtividade(
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated atividadeRequest: AtividadeRequest
    ): ResponseEntity<AtividadeResponse> {
        val novaAtividade = atividadeInput.createAtividade(atividadeRequest)
        return ResponseEntity.status(201).body(novaAtividade)
    }

    @PatchMapping("/{id}")
    fun updateAtividade(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated atividadeRequest: AtividadeRequest
    ): ResponseEntity<Void> {
        atividadeInput.updateAtividade(id, atividadeRequest)
        return ResponseEntity.noContent().build()
    }
}
