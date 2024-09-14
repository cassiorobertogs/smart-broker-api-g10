package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class ContextoResponse(
    @JsonProperty("id")
    val id: Long,

    @JsonProperty("prompt")
    val prompt: String,

    @JsonProperty("coeficiente_didatico")
    val coeficienteDidatico: Double
)
