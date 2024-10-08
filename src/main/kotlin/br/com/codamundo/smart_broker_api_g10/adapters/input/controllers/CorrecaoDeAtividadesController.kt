package br.com.codamundo.smart_broker_api_g10.adapters.input.controllers

import br.com.codamundo.smart_broker_api_g10.application.ports.input.CorrecaoDeAtividadesInput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.RespostaBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.CorrecaoResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/correcao-atividades")
class CorrecaoDeAtividadesController(private val correcaoDeAtividadesInput: CorrecaoDeAtividadesInput) {

    @PostMapping("/{atividadeId}/{alunoId}")
    fun corrigirAtividade(
        @PathVariable atividadeId: Long,
        @PathVariable alunoId: Long,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?,
        @RequestBody respostaBodyDto: RespostaBodyDto
    ): ResponseEntity<CorrecaoResponse> {
        val correcao = correcaoDeAtividadesInput.corrigirAtividade(atividadeId, alunoId, respostaBodyDto)
        return ResponseEntity.ok(correcao)
    }

    // Buscar todas as respostas de um aluno específico
    @GetMapping("/aluno/{alunoId}")
    fun getRespostasPorAluno(
        @PathVariable alunoId: Long,
        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?
    ): ResponseEntity<List<CorrecaoResponse>> {
        val respostas = correcaoDeAtividadesInput.findRespostasByAlunoId(alunoId)
        return ResponseEntity.ok(respostas)
    }

    // Excluir todas as respostas associadas a uma atividade específica
    @DeleteMapping("/atividade/{atividadeId}")
    fun deletarRespostasPorAtividade(
        @PathVariable atividadeId: Long,

        @RequestHeader(value = "X-Request-ID", required = false) requestId: String?
    ): ResponseEntity<Void> {
        correcaoDeAtividadesInput.deleteRespostasByAtividadeId(atividadeId)
        return ResponseEntity.noContent().build()
    }
}
