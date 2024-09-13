package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

import br.com.codamundo.smart_broker_api_g10.application.ports.input.CorrecaoDeAtividadesInput
import br.com.codamundo.smart_broker_api_g10.shared.dto.RespostaBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.CorrecaoResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/correcao-atividades")
class CorrecaoDeAtividadesController(private val correcaoDeAtividadesInput: CorrecaoDeAtividadesInput) {

    @PostMapping("/{atividadeId}")
    fun corrigirAtividade(
        @PathVariable atividadeId: Long,
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody (required = false) respostaBodyDto: RespostaBodyDto
    ): ResponseEntity<CorrecaoResponse> {
        val correcao = correcaoDeAtividadesInput.corrigirAtividade(atividadeId)
        return ResponseEntity.ok(correcao)
    }
}
