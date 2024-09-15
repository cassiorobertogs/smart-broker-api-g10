package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.RespostaBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.CorrecaoResponse

interface CorrecaoDeAtividadesInput {

    // Método para corrigir a atividade de um aluno específico
    fun corrigirAtividade(
        atividadeId: Long,
        alunoId: Long,
        respostaBodyDto: RespostaBodyDto
    ): CorrecaoResponse

    // Método para recuperar todas as respostas de um aluno específico
    fun findRespostasByAlunoId(alunoId: Long): List<CorrecaoResponse>

    // Método para deletar todas as respostas associadas a uma atividade específica
    fun deleteRespostasByAtividadeId(atividadeId: Long)
}
