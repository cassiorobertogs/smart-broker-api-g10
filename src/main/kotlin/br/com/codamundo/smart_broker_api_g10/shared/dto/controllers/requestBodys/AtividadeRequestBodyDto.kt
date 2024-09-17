package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys

import com.fasterxml.jackson.annotation.JsonProperty

data class AtividadeRequestBodyDto(
    val idTurma: Long,
    val idProfessor: Long,
    val enunciado: String,
    val respostaEsperada: String,
    val areaConhecimento: String,
    val nivelDificuldade: String,
    val objetivosAprendizagem: String
)

