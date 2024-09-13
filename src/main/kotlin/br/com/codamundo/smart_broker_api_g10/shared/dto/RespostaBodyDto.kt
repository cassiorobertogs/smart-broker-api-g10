package br.com.codamundo.smart_broker_api_g10.shared.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class  RespostaBodyDto(
    @JsonProperty("id_atividade")
    val idAtividade: Long,

    @JsonProperty("id_aluno")
    val idAluno: Long,

    @JsonProperty("resposta_aluno")
    val respostaAluno: String
)

