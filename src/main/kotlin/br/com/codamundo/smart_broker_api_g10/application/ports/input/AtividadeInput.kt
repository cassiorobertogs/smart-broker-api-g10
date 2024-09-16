package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.AtividadeRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.AtividadeResponse

interface AtividadeInput {

    fun getAtividade(id: Long): AtividadeResponse

    fun getAllAtividades(): List<AtividadeResponse>

    fun createAtividade(atividadeRequest: AtividadeRequestBodyDto): AtividadeResponse

    fun updateAtividade(id: Long, atividadeRequest: AtividadeRequestBodyDto): AtividadeResponse

    fun deleteAtividade(id: Long)
}
