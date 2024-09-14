package br.com.codamundo.smart_broker_api_g10.shared.dto.gateways.requestBodys

data class GptRequestDto(
    val model: String,
    val messages: List<MessageDto>
)

data class MessageDto(
    val role: String,
    val content: String
)
