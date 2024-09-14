package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class AlunoResponse(
    @JsonProperty("id")
    val id: Long,

    @JsonProperty("nome")
    val nome: String,

    @JsonProperty("idade")
    val idade: Int,

    @JsonProperty("turma")
    val turma: String,

    @JsonProperty("pessoa_com_deficiencia")
    val pessoaComDeficiencia: Boolean,

    @JsonProperty("estilo_aprendizagem")
    val estiloAprendizagem: String?,

    @JsonProperty("interesses_hobbies")
    val interessesHobbies: String?,

    @JsonProperty("passa_tempo_preferido")
    val passaTempoPreferido: String?,

    @JsonProperty("filme_serie_preferido")
    val filmeSeriePreferido: String?,

    @JsonProperty("artista")
    val artista: String?
)
