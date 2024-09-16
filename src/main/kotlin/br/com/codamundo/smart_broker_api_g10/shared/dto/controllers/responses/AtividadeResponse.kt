package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.AtividadeEntity

data class AtividadeResponse(
    val id: Long,
    val oficinaId: Long,
    val enunciado: String?,
    val respostaEsperada: String?,
    val areaConhecimento: String?,
    val nivelDificuldade: String?,
    val objetivosAprendizagem: String?
) {
    companion object {
        fun fromEntity(atividadeEntity: AtividadeEntity): AtividadeResponse {
            return AtividadeResponse(
                id = atividadeEntity.atividadeId!!,
                oficinaId = atividadeEntity.oficina.oficinaId!!,
                enunciado = atividadeEntity.enunciado,
                respostaEsperada = atividadeEntity.respostaEsperada,
                areaConhecimento = atividadeEntity.areaConhecimento,
                nivelDificuldade = atividadeEntity.nivelDificuldade,
                objetivosAprendizagem = atividadeEntity.objetivosAprendizagem
            )
        }
    }
}
