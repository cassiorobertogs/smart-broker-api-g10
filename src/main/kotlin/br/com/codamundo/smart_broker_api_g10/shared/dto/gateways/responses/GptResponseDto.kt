package br.com.codamundo.smart_broker_api_g10.shared.dto.gateways.responses

data class GptResponseDto(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val choices: List<ChoiceDto>,
    val usage: UsageDto
)

data class ChoiceDto(
    val index: Int,
    val message: MessageDto,
    val finish_reason: String
)

data class UsageDto(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)
