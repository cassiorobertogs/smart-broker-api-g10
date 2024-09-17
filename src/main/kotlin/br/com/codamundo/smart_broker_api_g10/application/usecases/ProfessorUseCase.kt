package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.ProfessorInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.ProfessorResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.ProfessorRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.ProfessorEntity
import org.springframework.stereotype.Service

@Service
class ProfessorUseCase(private val databaseOutput: DatabaseOutput) : ProfessorInput {

    override fun getProfessor(id: Long): ProfessorResponse {
        val professorEntity = databaseOutput.findProfessorById(id)
            ?: throw NotFoundException("Professor não encontrado com id $id")
        return ProfessorResponse.fromEntity(professorEntity)
    }

    override fun getAllProfessores(): List<ProfessorResponse> {
        val professores = databaseOutput.findAllProfessores()
        return professores.map { ProfessorResponse.fromEntity(it) }
    }

    override fun createProfessor(professorRequest: ProfessorRequestBodyDto): ProfessorResponse {
        val professorEntity = ProfessorEntity(
            nome = professorRequest.nome,
            especialidade = professorRequest.especialidade
        )
        val savedProfessor = databaseOutput.saveProfessor(professorEntity)
        return ProfessorResponse.fromEntity(savedProfessor)
    }

    override fun updateProfessor(id: Long, professorRequest: ProfessorRequestBodyDto) {
        val professorExistente = databaseOutput.findProfessorById(id)
            ?: throw NotFoundException("Professor não encontrado com id $id")

        // Verificar se o nome foi passado e só atualizar se necessário
        val updatedProfessor = professorExistente.copy(
            nome = professorRequest.nome ?: professorExistente.nome,
            especialidade = professorRequest.especialidade ?: professorExistente.especialidade
        )

        databaseOutput.saveProfessor(updatedProfessor)
    }

    override fun deleteProfessor(id: Long) {
        val professorExistente = databaseOutput.findProfessorById(id)
            ?: throw NotFoundException("Professor não encontrado com id $id")
        databaseOutput.deleteProfessor(id)
    }
}
