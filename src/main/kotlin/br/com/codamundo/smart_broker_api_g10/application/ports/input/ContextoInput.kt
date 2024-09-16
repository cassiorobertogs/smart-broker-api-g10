package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.ContextoRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.ContextoResponse

interface ContextoInput {
    fun getContexto(id: Long): ContextoResponse
    fun createContexto(contextoRequest: ContextoRequestBodyDto): ContextoResponse
    fun updateContexto(id: Long, contextoRequest: ContextoRequestBodyDto)
    fun getAllContextos(): List<ContextoResponse>
    fun deleteContexto(id: Long)  // Adicionado o método para deletar contexto
}
