package br.com.codamundo.smart_broker_api_g10.shared.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AtividadeRequestBodyDto(
    @JsonProperty("id_turma")
    val idTurma: Long,

    @JsonProperty("id_professor")
    val idProfessor: Long,

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

