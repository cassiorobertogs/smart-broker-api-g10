package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.TurmaEntity

data class TurmaResponse(
    val id: Long,
    val quantidadeAlunos: Int?,
    val professorId: Long,
    val professorNome: String?
) {
    companion object {
        fun fromEntity(turmaEntity: TurmaEntity): TurmaResponse {
            return TurmaResponse(
                id = turmaEntity.idTurma!!,
                quantidadeAlunos = turmaEntity.quantidadeAlunos,
                professorId = turmaEntity.professor.idProfessor!!,
                professorNome = turmaEntity.professor.nome
            )
        }
    }
}
