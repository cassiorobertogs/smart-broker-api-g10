package br.com.codamundo.smart_broker_api_g10.application.ports.output

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.*

interface DatabaseOutput {

    // Métodos relacionados ao Aluno
    fun findAlunoById(id: Long): AlunoEntity?
    fun saveAluno(aluno: AlunoEntity): AlunoEntity
    fun deleteAluno(id: Long)

    // Métodos relacionados à Atividade
    fun findAtividadeById(id: Long): AtividadeEntity?
    fun saveAtividade(atividade: AtividadeEntity): AtividadeEntity
    fun deleteAtividade(id: Long)

    // Métodos relacionados ao Professor
    fun findProfessorById(id: Long): ProfessorEntity?
    fun saveProfessor(professor: ProfessorEntity): ProfessorEntity
    fun deleteProfessor(id: Long)

    // Métodos relacionados ao Contexto
    fun findContextoById(id: Long): ContextoEntity?
    fun findContextoPadrao(): ContextoEntity?
    fun saveContexto(contexto: ContextoEntity): ContextoEntity
    fun deleteContexto(id: Long)

    // Métodos relacionados à Oficina
    fun findAllOficinas(): List<OficinaEntity>
    fun findOficinaById(id: Long): OficinaEntity?
    fun saveOficina(oficina: OficinaEntity): OficinaEntity
    fun deleteOficina(id: Long)

    // Métodos relacionados à Turma
    fun findTurmaById(id: Long): TurmaEntity?
    fun saveTurma(turma: TurmaEntity): TurmaEntity
    fun deleteTurma(id: Long)

    // Métodos relacionados à Resposta
    fun findRespostaById(id: Long): RespostaEntity?
    fun saveResposta(resposta: RespostaEntity): RespostaEntity
    fun deleteResposta(id: Long)
}
