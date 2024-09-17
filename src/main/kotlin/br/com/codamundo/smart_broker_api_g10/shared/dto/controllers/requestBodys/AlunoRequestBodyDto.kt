package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys

import com.fasterxml.jackson.annotation.JsonProperty

data class AlunoRequestBodyDto(
    val nome: String,
    val idade: Int,
    val idTurma: Long,
    val pessoaComDeficiencia: Boolean,
    val estiloAprendizagem: String?,
    val interessesHobbies: String?,
    val passaTempoPreferido: String?,
    val filmeSeriePreferido: String?,
    val artista: String?
)