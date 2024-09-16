package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.AlunoResponse
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.AlunoRequestBodyDto

interface AlunoInput {

    fun getAluno(id: Long): AlunoResponse

    fun getAllAlunos(): List<AlunoResponse>

    fun createAluno(alunoRequest: AlunoRequestBodyDto): AlunoResponse

    fun updateAluno(id: Long, alunoRequest: AlunoRequestBodyDto)

    fun deleteAluno(id: Long)
}
