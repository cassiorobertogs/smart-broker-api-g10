package br.com.codamundo.smart_broker_api_g10.application.ports.input

interface AlunoInput {

    fun getAluno(id: Long): AlunoResponse

    fun createAluno(alunoRequest: AlunoRequest): AlunoResponse

    fun updateAluno(id: Long, alunoRequest: AlunoRequest)
}