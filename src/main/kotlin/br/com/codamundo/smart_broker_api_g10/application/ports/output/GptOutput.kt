package br.com.codamundo.smart_broker_api_g10.application.ports.output

import br.com.codamundo.smart_broker_api_g10.shared.dto.GptResponseDto

interface GptOutput {
    fun postEnriquecerCorrecao(requestBody: String): GptResponseDto
}
