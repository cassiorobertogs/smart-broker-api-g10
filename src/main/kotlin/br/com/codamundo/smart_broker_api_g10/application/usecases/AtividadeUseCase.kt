package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.AtividadeInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.AtividadeResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.AtividadeRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.AtividadeEntity

class AtividadeUseCase(private val databaseOutput: DatabaseOutput) : AtividadeInput {

    override fun getAtividade(id: Long): AtividadeResponse {
        val atividadeEntity = databaseOutput.findAtividadeById(id)
            ?: throw NotFoundException("Atividade não encontrada com id $id")
        return AtividadeResponse.fromEntity(atividadeEntity)
    }

    override fun createAtividade(atividadeDto: AtividadeRequestBodyDto): AtividadeResponse {
        val oficina = databaseOutput.findOficinaById(atividadeDto.oficinaId)
            ?: throw NotFoundException("Oficina não encontrada com id ${atividadeDto.oficinaId}")
        val atividadeEntity = AtividadeEntity(
            oficina = oficina,
            enunciado = atividadeDto.enunciado,
            respostaEsperada = atividadeDto.respostaEsperada,
            areaConhecimento = atividadeDto.areaConhecimento,
            nivelDificuldade = atividadeDto.nivelDificuldade,
            objetivosAprendizagem = atividadeDto.objetivosAprendizagem
        )
        val savedAtividade = databaseOutput.saveAtividade(atividadeEntity)
        return AtividadeResponse.fromEntity(savedAtividade)
    }

    override fun updateAtividade(id: Long, atividadeDto: AtividadeRequestBodyDto) {
        val atividadeExistente = databaseOutput.findAtividadeById(id)
            ?: throw NotFoundException("Atividade não encontrada com id $id")
        val oficina = databaseOutput.findOficinaById(atividadeDto.oficinaId)
            ?: throw NotFoundException("Oficina não encontrada com id ${atividadeDto.oficinaId}")
        val updatedAtividade = atividadeExistente.copy(
            oficina = oficina,
            enunciado = atividadeDto.enunciado ?: atividadeExistente.enunciado,
            respostaEsperada = atividadeDto.respostaEsperada ?: atividadeExistente.respostaEsperada,
            areaConhecimento = atividadeDto.areaConhecimento ?: atividadeExistente.areaConhecimento,
            nivelDificuldade = atividadeDto.nivelDificuldade ?: atividadeExistente.nivelDificuldade,
            objetivosAprendizagem = atividadeDto.objetivosAprendizagem ?: atividadeExistente.objetivosAprendizagem
        )
        databaseOutput.saveAtividade(updatedAtividade)
    }

    override fun deleteAtividade(id: Long) {
        if (databaseOutput.findAtividadeById(id) == null) {
            throw NotFoundException("Atividade não encontrada com id $id")
        }
        databaseOutput.deleteAtividade(id)
    }
}
