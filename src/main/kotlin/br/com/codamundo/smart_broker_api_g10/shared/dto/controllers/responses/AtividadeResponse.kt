package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class AtividadeResponse(
    @JsonProperty("id")
    val id: Long,

    @JsonProperty("enunciado")
    val enunciado: String,

    @JsonProperty("resposta_esperada")
    val respostaEsperada: String,

    @JsonProperty("area_conhecimento")
    val areaConhecimento: String,

    @JsonProperty("nivel_dificuldade")
    val nivelDificuldade: String,

    @JsonProperty("objetivos_aprendizagem")
    val objetivosAprendizagem: String
)
