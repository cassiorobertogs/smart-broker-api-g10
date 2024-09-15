package br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys

data class TurmaRequest(
    val nome: String?,
    val quantidadeAlunos: Int?,
    val professorId: Long?,
    val oficinaId: Long?
)
