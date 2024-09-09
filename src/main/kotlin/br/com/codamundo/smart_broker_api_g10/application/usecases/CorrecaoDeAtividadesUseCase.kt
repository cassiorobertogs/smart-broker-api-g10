package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.adapters.output.gateways.GptGatewayImpl
import br.com.codamundo.smart_broker_api_g10.application.ports.input.CorrecaoDeAtividadesInput
import br.com.codamundo.smart_broker_api_g10.domain.models.Correcao

class CorrecaoDeAtividadesUseCase(private val gptGateway: GptGatewayImpl) : CorrecaoDeAtividadesInput {

    override fun corrigirAtividade(atividadeId: Long): Correcao {
        // Lógica para corrigir a atividade usando GPT
        return gptGateway.corrigirAtividade(atividadeId)
    }
}
