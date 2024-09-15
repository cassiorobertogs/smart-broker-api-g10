package br.com.codamundo.smart_broker_api_g10.application.ports.input

import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.requestBodys.ProfessorRequestBodyDto
import br.com.codamundo.smart_broker_api_g10.shared.dto.controllers.responses.ProfessorResponse

interface ProfessorInput {

    fun getProfessor(id: Long): ProfessorResponse

    fun getAllProfessores(): List<ProfessorResponse>

    fun createProfessor(professorRequest: ProfessorRequestBodyDto): ProfessorResponse

    fun updateProfessor(id: Long, professorRequest: ProfessorRequestBodyDto)

    fun deleteProfessor(id: Long)
}
