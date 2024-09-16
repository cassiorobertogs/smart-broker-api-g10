package br.com.codamundo.smart_broker_api_g10.application.ports.output

interface GptOutput {
    fun postEnriquecerCorrecao(prompt: String): String
}
