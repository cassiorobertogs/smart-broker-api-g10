package br.com.codamundo.smart_broker_api_g10.application.ports.input

interface ProfessorInput {

    fun getProfessor(id: Long): ProfessorResponse

    fun createProfessor(professorRequest: ProfessorRequest): ProfessorResponse

    fun updateProfessor(id: Long, professorRequest: ProfessorRequest)
}