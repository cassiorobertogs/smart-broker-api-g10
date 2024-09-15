package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.OficinaResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.OficinaRequest

interface OficinaInput {
    fun getAllOficinas(): List<OficinaResponse>
    fun getOficina(id: Long): OficinaResponse
    fun createOficina(request: OficinaRequest): OficinaResponse
    fun updateOficina(id: Long, request: OficinaRequest)
    fun deleteOficina(id: Long)
}
