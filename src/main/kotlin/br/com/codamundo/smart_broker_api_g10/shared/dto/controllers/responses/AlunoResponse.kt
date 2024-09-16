package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.AlunoEntity

data class AlunoResponse(
    val id: Long,
    val nome: String?,
    val idade: Int?,
    val turmaId: Long,
    val pessoaComDeficiencia: Boolean?,
    val tipoDeDeficiencia: String?,
    val estiloAprendizagem: String?,
    val interessesHobbies: String?,
    val passaTempoPreferido: String?,
    val filmeSeriePreferido: String?,
    val artista: String?
) {
    companion object {
        fun fromEntity(alunoEntity: AlunoEntity): AlunoResponse {
            return AlunoResponse(
                id = alunoEntity.alunoId!!,
                nome = alunoEntity.nome,
                idade = alunoEntity.idade,
                turmaId = alunoEntity.turma.idTurma!!,
                pessoaComDeficiencia = alunoEntity.pessoaComDeficiencia,
                tipoDeDeficiencia = alunoEntity.tipoDeDeficiencia,
                estiloAprendizagem = alunoEntity.estiloAprendizagem,
                interessesHobbies = alunoEntity.interessesHobbies,
                passaTempoPreferido = alunoEntity.passaTempoPreferido,
                filmeSeriePreferido = alunoEntity.filmeSeriePreferido,
                artista = alunoEntity.artista
            )
        }
    }
}
