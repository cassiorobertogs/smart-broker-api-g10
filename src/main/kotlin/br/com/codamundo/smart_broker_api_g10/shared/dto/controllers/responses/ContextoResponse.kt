package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.ContextoEntity

data class ContextoResponse(
    val id: Long,
    val prompt: String?,
    val coeficienteDidatico: Double?
) {
    companion object {
        fun fromEntity(contextoEntity: ContextoEntity): ContextoResponse {
            return ContextoResponse(
                id = contextoEntity.idContexto!!,
                prompt = contextoEntity.prompt,
                coeficienteDidatico = contextoEntity.coeficienteDidatico
            )
        }
    }
}
