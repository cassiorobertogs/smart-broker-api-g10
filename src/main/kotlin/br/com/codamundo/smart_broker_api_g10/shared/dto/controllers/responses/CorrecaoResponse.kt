package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class CorrecaoResponse(
    @JsonProperty("id")
    val id: Long,

    @JsonProperty("resposta_aluno")
    val respostaAluno: String,

    @JsonProperty("coeficiente_acertividade")
    val coeficienteAcertividade: Double,

    @JsonProperty("data_hora_resposta")
    val dataHoraResposta: LocalDateTime
)

