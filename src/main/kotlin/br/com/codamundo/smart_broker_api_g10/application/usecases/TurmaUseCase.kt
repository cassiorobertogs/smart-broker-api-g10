package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.TurmaInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.TurmaResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.TurmaRequest
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.TurmaEntity
import org.springframework.stereotype.Service

@Service
class TurmaUseCase(
    private val databaseOutput: DatabaseOutput
) : TurmaInput {

    override fun getTurma(id: Long): TurmaResponse {
        val turmaEntity = databaseOutput.findTurmaById(id)
            ?: throw NotFoundException("Turma não encontrada com id $id")
        return TurmaResponse.fromEntity(turmaEntity)
    }

    override fun createTurma(request: TurmaRequest): TurmaResponse {
        val oficina = databaseOutput.findOficinaById(request.oficinaId!!)
            ?: throw NotFoundException("Oficina não encontrada com id ${request.oficinaId}")

        val professor = databaseOutput.findProfessorById(request.professorId!!)
            ?: throw NotFoundException("Professor não encontrado com id ${request.professorId}")

        val turmaEntity = TurmaEntity(
            oficina = oficina,
            professor = professor,
            quantidadeAlunos = request.quantidadeAlunos
        )
        val savedTurma = databaseOutput.saveTurma(turmaEntity)

        return TurmaResponse.fromEntity(savedTurma)
    }

    override fun updateTurma(id: Long, request: TurmaRequest) {
        val turmaExistente = databaseOutput.findTurmaById(id)
            ?: throw NotFoundException("Turma não encontrada com id $id")

        val oficina = if (request.oficinaId != null) {
            databaseOutput.findOficinaById(request.oficinaId)
                ?: throw NotFoundException("Oficina não encontrada com id ${request.oficinaId}")
        } else {
            turmaExistente.oficina
        }

        val professor = if (request.professorId != null) {
            databaseOutput.findProfessorById(request.professorId)
                ?: throw NotFoundException("Professor não encontrado com id ${request.professorId}")
        } else {
            turmaExistente.professor
        }

        val updatedTurma = turmaExistente.copy(
            oficina = oficina,
            professor = professor,
            quantidadeAlunos = request.quantidadeAlunos ?: turmaExistente.quantidadeAlunos
        )
        databaseOutput.saveTurma(updatedTurma)
    }

    override fun deleteTurma(id: Long) {
        if (databaseOutput.findTurmaById(id) == null) {
            throw NotFoundException("Turma não encontrada com id $id")
        }
        databaseOutput.deleteTurma(id)
    }

    override fun getAllTurmas(): List<TurmaResponse> {
        val turmas = databaseOutput.findAllTurmas()
        if (turmas.isEmpty()) {
            throw NotFoundException("Nenhuma turma encontrada")
        }
        return turmas.map { TurmaResponse.fromEntity(it) }
    }
}
