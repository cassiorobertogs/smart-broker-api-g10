package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.application.ports.input.OficinaInput
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.OficinaEntity
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.OficinaRequest
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.OficinaResponse
import org.springframework.stereotype.Service

@Service
class OficinaUseCase(
    private val databaseOutput: DatabaseOutput
) : OficinaInput {

    override fun getAllOficinas(): List<OficinaResponse> {
        val oficinas = databaseOutput.findAllOficinas()
        return oficinas.map { OficinaResponse.fromEntity(it) }
    }

    override fun getOficina(id: Long): OficinaResponse {
        val oficina = databaseOutput.findOficinaById(id)
            ?: throw NotFoundException("Oficina não encontrada com id $id")

        return OficinaResponse.fromEntity(oficina)
    }

    override fun createOficina(request: OficinaRequest): OficinaResponse {
        val oficinaEntity = OficinaEntity(
            escola = request.escola
        )
        val savedOficina = databaseOutput.saveOficina(oficinaEntity)

        return OficinaResponse.fromEntity(savedOficina)
    }

    override fun updateOficina(id: Long, request: OficinaRequest) {
        val oficinaExistente = databaseOutput.findOficinaById(id)
            ?: throw NotFoundException("Oficina não encontrada com id $id")

        val updatedOficina = oficinaExistente.copy(
            escola = request.escola ?: oficinaExistente.escola
        )
        databaseOutput.saveOficina(updatedOficina)
    }

    override fun deleteOficina(id: Long) {
        if (databaseOutput.findOficinaById(id) == null) {
            throw NotFoundException("Oficina não encontrada com id $id")
        }
        databaseOutput.deleteOficina(id)
    }
}
