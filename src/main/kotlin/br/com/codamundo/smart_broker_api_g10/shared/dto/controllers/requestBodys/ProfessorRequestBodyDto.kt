package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys

import com.fasterxml.jackson.annotation.JsonProperty

data class ProfessorRequestBodyDto(
    @JsonProperty("nome")
    val nome: String,

    @JsonProperty("especialidade")
    val especialidade: String
)

