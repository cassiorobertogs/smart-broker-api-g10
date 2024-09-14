package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.RespostaBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.CorrecaoResponse

interface CorrecaoDeAtividadesInput {
    fun corrigirAtividade(
        atividadeId: Long,
        alunoId: Long,
        respostaDoAluno: RespostaBodyDto
    ): CorrecaoResponse
}
