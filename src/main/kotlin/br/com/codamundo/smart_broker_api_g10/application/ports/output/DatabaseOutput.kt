package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.*
import java.util.*

interface DatabaseOutput {

    // Métodos relacionados ao Aluno
    fun findAlunoById(id: Long): Optional<AlunoEntity>   // Retorna Optional de AlunoEntity
    fun saveAluno(aluno: AlunoEntity): AlunoEntity       // Salva e retorna o AlunoEntity
    fun updateAluno(aluno: AlunoEntity): AlunoEntity     // Atualiza e retorna o AlunoEntity

    // Métodos relacionados à Atividade
    fun findAtividadeById(id: Long): Optional<AtividadeEntity>   // Retorna Optional de AtividadeEntity
    fun saveAtividade(atividade: AtividadeEntity): AtividadeEntity
    fun updateAtividade(atividade: AtividadeEntity): AtividadeEntity

    // Métodos relacionados ao Professor
    fun findProfessorById(id: Long): Optional<ProfessorEntity>   // Retorna Optional de ProfessorEntity
    fun saveProfessor(professor: ProfessorEntity): ProfessorEntity
    fun updateProfessor(professor: ProfessorEntity): ProfessorEntity

    // Métodos relacionados ao Contexto
    fun findContextoById(id: Long): Optional<ContextoEntity>     // Retorna Optional de ContextoEntity
    fun saveContexto(contexto: ContextoEntity): ContextoEntity
    fun updateContexto(contexto: ContextoEntity): ContextoEntity

    // Métodos relacionados à Oficina
    fun findOficinaById(id: Long): Optional<OficinaEntity>       // Retorna Optional de OficinaEntity
    fun saveOficina(oficina: OficinaEntity): OficinaEntity       // Salva e retorna o OficinaEntity

    // Métodos relacionados à Turma
    fun findTurmaById(id: Long): Optional<TurmaEntity>           // Retorna Optional de TurmaEntity
    fun saveTurma(turma: TurmaEntity): TurmaEntity               // Salva e retorna o TurmaEntity

    // Métodos relacionados à Resposta
    fun findRespostaById(id: Long): Optional<RespostaEntity>     // Retorna Optional de RespostaEntity
    fun saveResposta(resposta: RespostaEntity): RespostaEntity   // Salva e retorna a RespostaEntity
}
a