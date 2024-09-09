package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.adapters.output.gateways.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.application.ports.input.AtividadeInput
import br.com.codamundo.smart_broker_api_g10.domain.models.Atividade

class AtividadeUseCase(private val databaseOutput DatabaseOutput) : AtividadeInput {

    override fun getAtividade(id: Long): Atividade {
        // Lógica para buscar uma atividade
        return databaseGateway.findAtividadeById(id)
    }

    override fun createAtividade(atividade: Atividade): Atividade {
        // Lógica para criar uma atividade
        return databaseGateway.saveAtividade(atividade)
    }

    override fun updateAtividade(id: Long, atividade: Atividade) {
        // Lógica para atualizar a atividade
        val atividadeExistente = databaseGateway.findAtividadeById(id)
        atividadeExistente?.let {
            databaseGateway.updateAtividade(atividadeExistente)
        }
    }
}
