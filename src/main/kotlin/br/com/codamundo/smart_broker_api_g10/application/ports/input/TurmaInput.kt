package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.TurmaResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.TurmaRequest

interface TurmaInput {
    fun getTurma(id: Long): TurmaResponse
    fun createTurma(request: TurmaRequest): TurmaResponse
    fun updateTurma(id: Long, request: TurmaRequest)
    fun deleteTurma(id: Long)
}
