package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys

import com.fasterxml.jackson.annotation.JsonProperty

data class  RespostaBodyDto(
    val idAtividade: Long,
    val idAluno: Long,
    val respostaAluno: String
)

