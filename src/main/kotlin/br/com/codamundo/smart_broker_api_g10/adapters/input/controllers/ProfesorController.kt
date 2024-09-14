package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

import br.com.codamundo.smart_broker_api_g10.application.ports.input.ProfessorInput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.ProfessorRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.ProfessorResponse
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated

@RestController
@RequestMapping("/api/professores")
class ProfesorController(private val professorInput: ProfessorInput) {

    @GetMapping("/{id}")
    fun getProfessor(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?
    ): ResponseEntity<ProfessorResponse> {
        val professor = professorInput.getProfessor(id)
        return ResponseEntity.ok(professor)
    }

    @PostMapping
    fun createProfessor(
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated professorRequestBodyDto: ProfessorRequestBodyDto
    ): ResponseEntity<ProfessorResponse> {
        val novoProfessor = professorInput.createProfessor(professorRequestBodyDto)
        return ResponseEntity.status(201).body(novoProfessor)
    }

    @PatchMapping("/{id}")
    fun updateProfessor(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated professorRequestBodyDto: ProfessorRequestBodyDto
    ): ResponseEntity<Void> {
        professorInput.updateProfessor(id, professorRequestBodyDto)
        return ResponseEntity.noContent().build()
    }
}
