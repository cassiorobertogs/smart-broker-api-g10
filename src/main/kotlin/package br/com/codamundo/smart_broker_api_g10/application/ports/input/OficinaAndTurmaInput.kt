package `package br`.com.codamundo.smart_broker_api_g10.application.ports.input

open class OficinaAndTurmaInput {
    open fun getOficinaAndTurma(id: Long): OficinaAndTurmaResponse {
        // Lógica para buscar uma oficina e turma
        return databaseGatewayImpl.findOficinaAndTurmaById(id)
    }

    open fun createOficinaAndTurma(oficinaAndTurmaRequest: OficinaAndTurmaRequest): OficinaAndTurmaResponse {
        // Lógica para criar uma oficina e turma
        return databaseGatewayImpl.saveOficinaAndTurma(oficinaAndTurmaRequest)
    }

    open fun updateOficinaAndTurma(id: Long, oficinaAndTurmaRequest: OficinaAndTurmaRequest) {
        // Lógica para atualizar a oficina e turma
        val oficinaAndTurmaExistente = databaseGatewayImpl.findOficinaAndTurmaById(id)
    }

}
