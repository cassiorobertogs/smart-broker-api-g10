package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.ProfessorInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.ProfessorResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.ProfessorRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.ProfessorEntity

class ProfessorUseCase(private val databaseOutput: DatabaseOutput) : ProfessorInput {

    override fun getProfessor(id: Long): ProfessorResponse {
        val professorEntity = databaseOutput.findProfessorById(id)
            ?: throw NotFoundException("Professor não encontrado com id $id")
        return ProfessorResponse.fromEntity(professorEntity)
    }

    override fun createProfessor(professorDto: ProfessorRequestBodyDto): ProfessorResponse {
        val professorEntity = ProfessorEntity(
            nome = professorDto.nome,
            especialidade = professorDto.especialidade
        )
        val savedProfessor = databaseOutput.saveProfessor(professorEntity)
        return ProfessorResponse.fromEntity(savedProfessor)
    }

    override fun updateProfessor(id: Long, professorDto: ProfessorRequestBodyDto) {
        val professorExistente = databaseOutput.findProfessorById(id)
            ?: throw NotFoundException("Professor não encontrado com id $id")
        val updatedProfessor = professorExistente.copy(
            nome = professorDto.nome ?: professorExistente.nome,
            especialidade = professorDto.especialidade ?: professorExistente.especialidade
        )
        databaseOutput.saveProfessor(updatedProfessor)
    }

    override fun deleteProfessor(id: Long) {
        if (databaseOutput.findProfessorById(id) == null) {
            throw NotFoundException("Professor não encontrado com id $id")
        }
        databaseOutput.deleteProfessor(id)
    }
}
