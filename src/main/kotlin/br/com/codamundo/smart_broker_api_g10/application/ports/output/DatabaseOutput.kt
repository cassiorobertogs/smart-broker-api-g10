package br.com.codamundo.smart_broker_api_g10.application.ports.output

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.*

interface DatabaseOutput {

    // Métodos relacionados ao Aluno
    fun findAlunoById(id: Long): AlunoEntity?
    fun findAllAlunos(): List<AlunoEntity>  // Recuperar todos os Alunos
    fun saveAluno(aluno: AlunoEntity): AlunoEntity
    fun deleteAluno(id: Long)

    // Métodos relacionados à Atividade
    fun findAtividadeById(id: Long): AtividadeEntity?
    fun findAllAtividades(): List<AtividadeEntity>  // Recuperar todas as Atividades
    fun saveAtividade(atividade: AtividadeEntity): AtividadeEntity
    fun deleteAtividade(id: Long)

    // Métodos relacionados ao Professor
    fun findProfessorById(id: Long): ProfessorEntity?
    fun findAllProfessores(): List<ProfessorEntity>  // Recuperar todos os Professores
    fun saveProfessor(professor: ProfessorEntity): ProfessorEntity
    fun deleteProfessor(id: Long)

    // Métodos relacionados ao Contexto
    fun findContextoById(id: Long): ContextoEntity?
    fun findAllContextos(): List<ContextoEntity>  // Recuperar todos os Contextos
    fun findContextoPadrao(): ContextoEntity?
    fun saveContexto(contexto: ContextoEntity): ContextoEntity
    fun deleteContexto(id: Long)

    // Métodos relacionados à Oficina
    fun findOficinaById(id: Long): OficinaEntity?
    fun findAllOficinas(): List<OficinaEntity>  // Recuperar todas as Oficinas
    fun saveOficina(oficina: OficinaEntity): OficinaEntity
    fun deleteOficina(id: Long)

    // Métodos relacionados à Turma
    fun findTurmaById(id: Long): TurmaEntity?
    fun findAllTurmas(): List<TurmaEntity>  // Recuperar todas as Turmas
    fun saveTurma(turma: TurmaEntity): TurmaEntity
    fun deleteTurma(id: Long)

    // Métodos relacionados à Resposta
    fun findRespostaById(id: Long): RespostaEntity?    // Buscar todas as respostas de um aluno específico
    fun findRespostasByAlunoId(alunoId: Long): List<RespostaEntity>    // Salvar uma resposta
    fun saveResposta(resposta: RespostaEntity): RespostaEntity    // Deletar todas as respostas associadas a uma atividade específica
    fun deleteRespostasByAtividadeId(atividadeId: Long)


}
