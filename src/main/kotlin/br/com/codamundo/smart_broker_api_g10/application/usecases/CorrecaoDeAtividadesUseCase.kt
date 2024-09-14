package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.application.ports.output.GptOutput
import br.com.codamundo.smart_broker_api_g10.shared.dto.gateways.requestBodys.GptRequestDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.gateways.requestBodys.MessageDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.gateways.responses.GptResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class GptGatewayImpl(
    private val webClientBuilder: WebClient.Builder,
    private val objectMapper: ObjectMapper,
    @Value("\${openai.api.key}") private val apiKey: String
) : GptOutput {

    override fun postEnriquecerCorrecao(prompt: String): String {
        // Construir o requestBody usando GptRequestDto
        val requestBody = GptRequestDto(
            model = "gpt-4", // Ou "gpt-3.5-turbo" se preferir
            messages = listOf(
                MessageDto(
                    role = "user",
                    content = prompt
                )
            )
        )

        // Fazer a requisição à API do GPT
        val responseEntity = requestGPT(requestBody).block()

        val statusCode = responseEntity?.statusCode?.value() ?: 500
        checkResponse(statusCode)

        val responseBody = responseEntity?.body ?: ""

        // Converter a resposta em GptResponseDto
        val gptResponseDto = convertRespostaGPT(responseBody)

        // Extrair o conteúdo da resposta do GPT
        val respostaGpt = gptResponseDto.choices.firstOrNull()?.message?.content
            ?: throw IllegalStateException("Resposta do GPT está vazia")

        return respostaGpt
    }

    private fun requestGPT(requestBody: GptRequestDto): Mono<ResponseEntity<String>> {
        return webClientBuilder.build()
            .post()
            .uri("https://api.openai.com/v1/chat/completions")
            .header("Authorization", "Bearer $apiKey")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchangeToMono { response ->
                response.toEntity(String::class.java)
            }
    }

    private fun checkResponse(statusCode: Int) {
        if (statusCode != HttpStatus.OK.value()) {
            throw IllegalStateException("Erro ao chamar GPT: Status Code $statusCode")
        }
    }

    private fun convertRespostaGPT(responseBody: String): GptResponseDto {
        return objectMapper.readValue(responseBody, GptResponseDto::class.java)
    }
}
