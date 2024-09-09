package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.domain.models.*

interface DatabaseOutput {

    // Métodos relacionados ao Aluno
    fun findAlunoById(id: Long): Aluno?           // Pode retornar um Aluno ou null
    fun saveAluno(aluno: Aluno): Aluno            // Retorna o Aluno salvo no banco
    fun updateAluno(aluno: Aluno): Aluno          // Atualiza o Aluno e retorna o resultado

    // Métodos relacionados à Atividade
    fun findAtividadeById(id: Long): Atividade?   // Pode retornar uma Atividade ou null
    fun saveAtividade(atividade: Atividade): Atividade
    fun updateAtividade(atividade: Atividade): Atividade

    // Métodos relacionados ao Professor
    fun findProfessorById(id: Long): Professor?   // Pode retornar um Professor ou null
    fun saveProfessor(professor: Professor): Professor
    fun updateProfessor(professor: Professor): Professor

    // Métodos relacionados ao Contexto
    fun findContextoById(id: Long): Contexto?     // Pode retornar um Contexto ou null
    fun saveContexto(contexto: Contexto): Contexto
    fun updateContexto(contexto: Contexto): Contexto
}
