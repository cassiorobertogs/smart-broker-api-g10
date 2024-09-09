package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

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
        @RequestBody @Validated professorRequest: ProfessorRequest
    ): ResponseEntity<ProfessorResponse> {
        val novoProfessor = professorInput.createProfessor(professorRequest)
        return ResponseEntity.status(201).body(novoProfessor)
    }

    @PatchMapping("/{id}")
    fun updateProfessor(
        @PathVariable id: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody @Validated professorRequest: ProfessorRequest
    ): ResponseEntity<Void> {
        professorInput.updateProfessor(id, professorRequest)
        return ResponseEntity.noContent().build()
    }
}
