package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.domain.models.*

interface DatabaseOutput {

    // Métodos relacionados ao Aluno
    fun findAlunoById(id: Long): Aluno?           // Retorna Aluno ou null
    fun saveAluno(aluno: Aluno): Aluno            // Retorna o Aluno salvo
    fun updateAluno(aluno: Aluno): Aluno          // Atualiza e retorna o Aluno

    // Métodos relacionados à Atividade
    fun findAtividadeById(id: Long): Atividade?   // Retorna Atividade ou null
    fun saveAtividade(atividade: Atividade): Atividade
    fun updateAtividade(atividade: Atividade): Atividade

    // Métodos relacionados ao Professor
    fun findProfessorById(id: Long): Professor?   // Retorna Professor ou null
    fun saveProfessor(professor: Professor): Professor
    fun updateProfessor(professor: Professor): Professor

    // Métodos relacionados ao Contexto
    fun findContextoById(id: Long): Contexto?     // Retorna Contexto ou null
    fun saveContexto(contexto: Contexto): Contexto
    fun updateContexto(contexto: Contexto): Contexto
}
