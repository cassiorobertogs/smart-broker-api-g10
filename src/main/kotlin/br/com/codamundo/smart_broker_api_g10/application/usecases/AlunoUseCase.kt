package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.*

interface DatabaseOutput {

    // Métodos relacionados ao Aluno
    fun findAlunoById(id: Long): AlunoEntity?
    fun saveAluno(aluno: AlunoEntity): AlunoEntity
    fun updateAluno(aluno: AlunoEntity): AlunoEntity

    // Métodos relacionados à Atividade
    fun findAtividadeById(id: Long): AtividadeEntity?
    fun saveAtividade(atividade: AtividadeEntity): AtividadeEntity
    fun updateAtividade(atividade: AtividadeEntity): AtividadeEntity

    // Métodos relacionados ao Professor
    fun findProfessorById(id: Long): ProfessorEntity?
    fun saveProfessor(professor: ProfessorEntity): ProfessorEntity
    fun updateProfessor(professor: ProfessorEntity): ProfessorEntity

    // Métodos relacionados ao Contexto
    fun findContextoById(id: Long): ContextoEntity?
    fun findContextoPadrao(): ContextoEntity?
    fun saveContexto(contexto: ContextoEntity): ContextoEntity
    fun updateContexto(contexto: ContextoEntity): ContextoEntity

    // Métodos relacionados à Oficina
    fun findOficinaById(id: Long): OficinaEntity?
    fun saveOficina(oficina: OficinaEntity): OficinaEntity

    // Métodos relacionados à Turma
    fun findTurmaById(id: Long): TurmaEntity?
    fun saveTurma(turma: TurmaEntity): TurmaEntity

    // Métodos relacionados à Resposta
    fun findRespostaById(id: Long): RespostaEntity?
    fun saveResposta(resposta: RespostaEntity): RespostaEntity
}
