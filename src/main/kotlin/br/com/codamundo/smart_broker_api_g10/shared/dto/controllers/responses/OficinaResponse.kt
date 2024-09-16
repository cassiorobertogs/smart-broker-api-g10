package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.OficinaEntity

data class OficinaResponse(
    val id: Long,
    val escola: String?
) {
    companion object {
        fun fromEntity(oficinaEntity: OficinaEntity): OficinaResponse {
            return OficinaResponse(
                id = oficinaEntity.oficinaId!!,
                escola = oficinaEntity.escola
            )
        }
    }
}
