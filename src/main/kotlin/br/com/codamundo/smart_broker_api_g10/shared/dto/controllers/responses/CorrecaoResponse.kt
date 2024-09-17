package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.RespostaEntity
import java.time.LocalDateTime

data class CorrecaoResponse(
    val id: Long,
    val respostaAluno: String?,
    val respostaCorrecao: String?,
    val coeficienteAcertividade: Double?,
    val dataHoraResposta: LocalDateTime?
) {
    companion object {
        fun fromEntity(respostaEntity: RespostaEntity): CorrecaoResponse {
            return CorrecaoResponse(
                id = respostaEntity.idResposta ?: 1,
                respostaAluno = respostaEntity.respostaAluno,
                respostaCorrecao = respostaEntity.respostaCorrecao,
                coeficienteAcertividade = respostaEntity.coeficienteAcertividade,
                dataHoraResposta = respostaEntity.dataHoraResposta
            )
        }
    }
}
