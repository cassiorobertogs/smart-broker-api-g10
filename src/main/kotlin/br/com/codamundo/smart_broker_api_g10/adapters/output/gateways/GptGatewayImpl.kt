package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.application.ports.output.GptOutput
import br.com.codamundo.smart_broker_api_g10.shared.dto.GptResponseDto
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.reactive.function.client.bodyToMono

@Component
class GptGatewayImpl(
    private val webClientBuilder: WebClient.Builder,
    private val objectMapper: ObjectMapper
) : GptOutput {

    override fun postEnriquecerCorrecao(requestBody: String): GptResponseDto {
        val response = requestGPT(requestBody)
        checkResponse(response.statusCode().value())
        return convertRespostaGPT(response.bodyToMono(String::class.java).block()!!)
    }

    private fun requestGPT(requestBody: String): WebClient.ResponseSpec {
        return webClientBuilder.build()
            .post()
            .uri("https://api.openai.com/v1/completions") // API do ChatGPT
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .retrieve()
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
