package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys

import com.fasterxml.jackson.annotation.JsonProperty

data class ContextoRequestBodyDto(
    val prompt: String,
    val coeficienteDidatico: Double
)
