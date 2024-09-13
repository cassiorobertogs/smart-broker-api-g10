package br.com.codamundo.smart_broker_api_g10.shared.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class  ContextoRequestBodyDto(
    @JsonProperty("prompt")
    val prompt: String,

    @JsonProperty("coeficiente_didatico")
    val coeficienteDidatico: Double
)

