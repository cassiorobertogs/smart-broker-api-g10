package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.adapters.output.gateways.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.application.ports.input.ContextoInput
import br.com.codamundo.smart_broker_api_g10.domain.models.Contexto

class ContextoUseCase(private val databaseOutput DatabaseOutput) : ContextoInput {

    override fun getContexto(id: Long): Contexto {
        // Lógica para buscar um contexto no banco de dados
        return databaseGateway.findContextoById(id)
    }

    override fun createContexto(contexto: Contexto): Contexto {
        // Lógica para criar um novo contexto
        return databaseGateway.saveContexto(contexto)
    }

    override fun updateContexto(id: Long, contexto: Contexto) {
        // Lógica para atualizar o contexto
        val contextoExistente = databaseGateway.findContextoById(id)
        contextoExistente?.let {
            // Atualização dos dados do contexto
            databaseGateway.updateContexto(contextoExistente)
        }
    }
}
