package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.domain.models.*

interface DatabaseOutput {

    // Métodos relacionados ao Aluno
    fun findAlunoById(id: Long): Aluno?           // Retorna Aluno ou null
    fun saveAluno(aluno: Aluno): Aluno            // Salva e retorna o Aluno
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

    // Métodos relacionados à Oficina
    fun findOficinaById(id: Long): Oficina?       // Retorna Oficina ou null
    fun saveOficina(oficina: Oficina): Oficina    // Salva e retorna a Oficina

    // Métodos relacionados à Turma
    fun findTurmaById(id: Long): Turma?           // Retorna Turma ou null
    fun saveTurma(turma: Turma): Turma            // Salva e retorna a Turma

    // Métodos relacionados à Resposta
    fun findRespostaById(id: Long): Resposta?     // Retorna Resposta ou null
    fun saveResposta(resposta: Resposta): Resposta // Salva e retorna a Resposta
}
