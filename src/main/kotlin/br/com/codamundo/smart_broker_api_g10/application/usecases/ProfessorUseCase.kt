package br.com.codamundo.smart_broker_api_g10.application.usecases

import br.com.codamundo.smart_broker_api_g10.adapters.output.gateways.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.application.ports.input.ProfessorInput
import br.com.codamundo.smart_broker_api_g10.domain.models.Professor

class ProfessorUseCase(private val databaseOutput DatabaseOutput) : ProfessorInput {

    override fun getProfessor(id: Long): Professor {
        // Lógica para buscar um professor
        return databaseGateway.findProfessorById(id)
    }

    override fun createProfessor(professor: Professor): Professor {
        // Lógica para criar um professor
        return databaseGateway.saveProfessor(professor)
    }

    override fun updateProfessor(id: Long, professor: Professor) {
        // Lógica para atualizar o professor
        val professorExistente = databaseGateway.findProfessorById(id)
        professorExistente?.let {
            databaseGateway.updateProfessor(professorExistente)
        }
    }
}
