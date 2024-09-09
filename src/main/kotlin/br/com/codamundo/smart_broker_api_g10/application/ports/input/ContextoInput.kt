package br.com.codamundo.smart_broker_api_g10.application.ports.input

data class ContextoInput() {
    fun getContexto(id: Long): ContextoResponse {
        return ContextoResponse()
    }

    fun createContexto(contextoRequest: ContextoRequest): ContextoResponse {
        return ContextoResponse()
    }

    fun updateContexto(id: Long, contextoRequest: ContextoRequest) {
    }
}
