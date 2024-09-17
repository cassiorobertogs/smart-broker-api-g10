package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

import br.com.codamundo.smart_broker_api_g10.application.ports.input.AtividadeInput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.AtividadeRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.AtividadeResponse
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated

@RestController
@RequestMapping("atividades")
class AtividadeController(private val atividadeInput: AtividadeInput) {

    @GetMapping("/{id}")
    fun getAtividade(
        @PathVariable id: Long,
        
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?
    ): ResponseEntity<AtividadeResponse> {
        val atividade = atividadeInput.getAtividade(id)
        return ResponseEntity.ok(atividade)
    }

    @GetMapping
    fun getAllAtividades(
        
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?
    ): ResponseEntity<List<AtividadeResponse>> {
        val atividades = atividadeInput.getAllAtividades()
        return ResponseEntity.ok(atividades)
    }

    @PostMapping
    fun createAtividade(
        
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated atividadeRequestBodyDto: AtividadeRequestBodyDto
    ): ResponseEntity<AtividadeResponse> {
        val novaAtividade = atividadeInput.createAtividade(atividadeRequestBodyDto)
        return ResponseEntity.status(201).body(novaAtividade)
    }

    @PatchMapping("/{id}")
    fun updateAtividade(
        @PathVariable id: Long,
        
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated atividadeRequestBodyDto: AtividadeRequestBodyDto
    ): ResponseEntity<Void> {
        atividadeInput.updateAtividade(id, atividadeRequestBodyDto)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun deleteAtividade(
        @PathVariable id: Long,
        
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?
    ): ResponseEntity<Void> {
        atividadeInput.deleteAtividade(id)
        return ResponseEntity.noContent().build()
    }
}
