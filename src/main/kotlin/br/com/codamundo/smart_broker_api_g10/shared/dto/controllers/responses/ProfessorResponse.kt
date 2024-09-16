package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.ProfessorEntity

data class ProfessorResponse(
    val id: Long,
    val nome: String?,
    val especialidade: String?
) {
    companion object {
        fun fromEntity(professorEntity: ProfessorEntity): ProfessorResponse {
            return ProfessorResponse(
                id = professorEntity.idProfessor!!,
                nome = professorEntity.nome,
                especialidade = professorEntity.especialidade
            )
        }
    }
}
