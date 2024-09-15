package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.AlunoInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.AlunoResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.AlunoRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.AlunoEntity

class AlunoUseCase(private val databaseOutput: DatabaseOutput) : AlunoInput {

    override fun getAluno(id: Long): AlunoResponse {
        val alunoEntity: AlunoEntity = databaseOutput.findAlunoById(id)
            ?: throw NotFoundException("Aluno não encontrado com id $id")
        return AlunoResponse.fromEntity(alunoEntity)
    }

    override fun createAluno(alunoDto: AlunoRequestBodyDto): AlunoResponse {
        val turma = databaseOutput.findTurmaById(alunoDto.turmaId)
            ?: throw NotFoundException("Turma não encontrada com id ${alunoDto.turmaId}")
        val alunoEntity = AlunoEntity(
            turma = turma,
            nome = alunoDto.nome,
            idade = alunoDto.idade,
            pessoaComDeficiencia = alunoDto.pessoaComDeficiencia,
            estiloAprendizagem = alunoDto.estiloAprendizagem,
            interessesHobbies = alunoDto.interessesHobbies,
            passaTempoPreferido = alunoDto.passaTempoPreferido,
            filmeSeriePreferido = alunoDto.filmeSeriePreferido,
            artista = alunoDto.artista
        )
        val savedAluno = databaseOutput.saveAluno(alunoEntity)
        return AlunoResponse.fromEntity(savedAluno)
    }

    override fun updateAluno(id: Long, alunoDto: AlunoRequestBodyDto) {
        val alunoExistente = databaseOutput.findAlunoById(id)
            ?: throw NotFoundException("Aluno não encontrado com id $id")
        val turma = databaseOutput.findTurmaById(alunoDto.turmaId)
            ?: throw NotFoundException("Turma não encontrada com id ${alunoDto.turmaId}")
        val updatedAluno = alunoExistente.copy(
            turma = turma,
            nome = alunoDto.nome ?: alunoExistente.nome,
            idade = alunoDto.idade ?: alunoExistente.idade,
            pessoaComDeficiencia = alunoDto.pessoaComDeficiencia ?: alunoExistente.pessoaComDeficiencia,
            estiloAprendizagem = alunoDto.estiloAprendizagem ?: alunoExistente.estiloAprendizagem,
            interessesHobbies = alunoDto.interessesHobbies ?: alunoExistente.interessesHobbies,
            passaTempoPreferido = alunoDto.passaTempoPreferido ?: alunoExistente.passaTempoPreferido,
            filmeSeriePreferido = alunoDto.filmeSeriePreferido ?: alunoExistente.filmeSeriePreferido,
            artista = alunoDto.artista ?: alunoExistente.artista
        )
        databaseOutput.saveAluno(updatedAluno)
    }

    override fun deleteAluno(id: Long) {
        if (databaseOutput.findAlunoById(id) == null) {
            throw NotFoundException("Aluno não encontrado com id $id")
        }
        databaseOutput.deleteAluno(id)
    }
}
