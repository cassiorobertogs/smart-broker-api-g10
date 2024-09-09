package br.com.codamundo.smart_broker_api_g10.application.ports.input

interface AtividadeInput {

    fun getAtividade(id: Long): AtividadeResponse

    fun createAtividade(atividadeRequest: AtividadeRequest): AtividadeResponse

    fun updateAtividade(id: Long, atividadeRequest: AtividadeRequest)
}