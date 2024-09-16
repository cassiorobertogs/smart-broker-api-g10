package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

import br.com.codamundo.smart_broker_api_g10.application.ports.input.OficinaInput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.OficinaResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.OficinaRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid

@RestController
@RequestMapping("/oficinas")
class OficinaController(private val oficinaInput: OficinaInput) {

    @GetMapping
    fun getAllOficinas(): ResponseEntity<List<OficinaResponse>> {
        val oficinas = oficinaInput.getAllOficinas()
        return ResponseEntity.ok(oficinas)
    }

    @GetMapping("/{id}")
    fun getOficina(@PathVariable id: Long): ResponseEntity<OficinaResponse> {
        val oficinaResponse = oficinaInput.getOficina(id)
        return ResponseEntity.ok(oficinaResponse)
    }

    @PostMapping
    fun createOficina(@Valid @RequestBody oficinaRequest: OficinaRequest): ResponseEntity<OficinaResponse> {
        val oficinaResponse = oficinaInput.createOficina(oficinaRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(oficinaResponse)
    }

    @PutMapping("/{id}")
    fun updateOficina(
        @PathVariable id: Long,
        @Valid @RequestBody oficinaRequest: OficinaRequest
    ): ResponseEntity<Void> {
        oficinaInput.updateOficina(id, oficinaRequest)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun deleteOficina(@PathVariable id: Long): ResponseEntity<Void> {
        oficinaInput.deleteOficina(id)
        return ResponseEntity.noContent().build()
    }
}
