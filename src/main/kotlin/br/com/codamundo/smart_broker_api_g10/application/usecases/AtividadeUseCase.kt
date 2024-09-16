package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.AtividadeInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.AtividadeEntity
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.AtividadeRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.AtividadeResponse

class AtividadeUseCase(private val databaseOutput: DatabaseOutput) : AtividadeInput {

    override fun getAtividade(id: Long): AtividadeResponse {
        val atividadeEntity = databaseOutput.findAtividadeById(id)
            ?: throw NotFoundException("Atividade não encontrada com id $id")
        return AtividadeResponse.fromEntity(atividadeEntity)
    }

    override fun getAllAtividades(): List<AtividadeResponse> {
        val atividades = databaseOutput.findAllAtividades()
        return atividades.map { AtividadeResponse.fromEntity(it) }
    }

    override fun createAtividade(atividadeDto: AtividadeRequestBodyDto): AtividadeResponse {
        val turma = databaseOutput.findTurmaById(atividadeDto.idTurma)
            ?: throw NotFoundException("Turma não encontrada com id ${atividadeDto.idTurma}")

        val professor = databaseOutput.findProfessorById(atividadeDto.idProfessor)
            ?: throw NotFoundException("Professor não encontrado com id ${atividadeDto.idProfessor}")

        val atividadeEntity = AtividadeEntity(
            oficina = turma.oficina,
            enunciado = atividadeDto.enunciado,
            respostaEsperada = atividadeDto.respostaEsperada,
            areaConhecimento = atividadeDto.areaConhecimento,
            nivelDificuldade = atividadeDto.nivelDificuldade,
            objetivosAprendizagem = atividadeDto.objetivosAprendizagem
        )
        val savedAtividade = databaseOutput.saveAtividade(atividadeEntity)
        return AtividadeResponse.fromEntity(savedAtividade)
    }

    override fun updateAtividade(id: Long, atividadeDto: AtividadeRequestBodyDto): AtividadeResponse {
        val atividadeExistente = databaseOutput.findAtividadeById(id)
            ?: throw NotFoundException("Atividade não encontrada com id $id")

        val turma = databaseOutput.findTurmaById(atividadeDto.idTurma)
            ?: throw NotFoundException("Turma não encontrada com id ${atividadeDto.idTurma}")

        val updatedAtividade = atividadeExistente.copy(
            oficina = turma.oficina,
            enunciado = atividadeDto.enunciado ?: atividadeExistente.enunciado,
            respostaEsperada = atividadeDto.respostaEsperada ?: atividadeExistente.respostaEsperada,
            areaConhecimento = atividadeDto.areaConhecimento ?: atividadeExistente.areaConhecimento,
            nivelDificuldade = atividadeDto.nivelDificuldade ?: atividadeExistente.nivelDificuldade,
            objetivosAprendizagem = atividadeDto.objetivosAprendizagem ?: atividadeExistente.objetivosAprendizagem
        )
        val savedAtividade = databaseOutput.saveAtividade(updatedAtividade)
        return AtividadeResponse.fromEntity(savedAtividade)
    }

    override fun deleteAtividade(id: Long) {
        val atividadeExistente = databaseOutput.findAtividadeById(id)
            ?: throw NotFoundException("Atividade não encontrada com id $id")
        databaseOutput.deleteAtividade(id)
    }
}
