package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.ContextoInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.ContextoResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.ContextoRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.ContextoEntity
import org.springframework.stereotype.Service

@Service
class ContextoUseCase(private val databaseOutput: DatabaseOutput) : ContextoInput {

    override fun getContexto(id: Long): ContextoResponse {
        val contextoEntity = databaseOutput.findContextoById(id)
            ?: throw NotFoundException("Contexto não encontrado com id $id")
        return ContextoResponse.fromEntity(contextoEntity)
    }

    override fun createContexto(contextoDto: ContextoRequestBodyDto): ContextoResponse {
        val contextoEntity = ContextoEntity(
            prompt = contextoDto.prompt,
            coeficienteDidatico = contextoDto.coeficienteDidatico
        )
        val savedContexto = databaseOutput.saveContexto(contextoEntity)
        return ContextoResponse.fromEntity(savedContexto)
    }

    override fun updateContexto(id: Long, contextoDto: ContextoRequestBodyDto) {
        val contextoExistente = databaseOutput.findContextoById(id)
            ?: throw NotFoundException("Contexto não encontrado com id $id")
        val updatedContexto = contextoExistente.copy(
            prompt = contextoDto.prompt ?: contextoExistente.prompt,
            coeficienteDidatico = contextoDto.coeficienteDidatico ?: contextoExistente.coeficienteDidatico
        )
        databaseOutput.saveContexto(updatedContexto)
    }

    override fun deleteContexto(id: Long) {
        // Verifica se o contexto existe antes de tentar deletar
        val contextoExistente = databaseOutput.findContextoById(id)
            ?: throw NotFoundException("Contexto não encontrado com id $id")

        // Lógica de deleção do contexto
        databaseOutput.deleteContexto(id)
    }

    override fun getAllContextos(): List<ContextoResponse> {
        val contextos = databaseOutput.findAllContextos()  // Obtém todos os contextos do banco de dados
        return contextos.map { ContextoResponse.fromEntity(it) }  // Converte para uma lista de ContextoResponse
    }
}
