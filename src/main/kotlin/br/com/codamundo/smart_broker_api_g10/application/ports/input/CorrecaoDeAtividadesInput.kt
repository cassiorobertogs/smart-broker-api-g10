package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.domain.models.Correcao

interface CorrecaoDeAtividadesInput {

    // Método para corrigir uma atividade
    fun corrigirAtividade(atividadeId: Long): Correcao
}
