package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class ProfessorResponse(
    @JsonProperty("id")
    val id: Long,

    @JsonProperty("nome")
    val nome: String,

    @JsonProperty("especialidade")
    val especialidade: String
)
