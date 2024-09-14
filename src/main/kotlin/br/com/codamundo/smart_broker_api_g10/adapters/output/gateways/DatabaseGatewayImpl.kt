package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.adapters.output.repositories.*
import br.com.codamundo.smart_broker_api_g10.domain.entities.*
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.*
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

@Component
class DatabaseGatewayImpl @Autowired constructor(
    private val alunoRepository: AlunoRepository,
    private val atividadeRepository: AtividadeRepository,
    private val professorRepository: ProfessorRepository,
    private val contextoRepository: ContextoRepository,
    private val oficinaRepository: OficinaRepository,
    private val turmaRepository: TurmaRepository,
    private val respostaRepository: RespostaRepository
) : DatabaseOutput {

    // Métodos relacionados ao Aluno
    override fun findAlunoById(id: Long): AlunoEntity? {
        return alunoRepository.findById(id).orElse(null)
    }

    override fun saveAluno(aluno: AlunoEntity): AlunoEntity {
        return alunoRepository.save(aluno)
    }

    override fun updateAluno(aluno: AlunoEntity): AlunoEntity {
        return alunoRepository.save(aluno)
    }

    // Métodos relacionados à Atividade
    override fun findAtividadeById(id: Long): AtividadeEntity? {
        return atividadeRepository.findById(id).orElse(null)
    }

    override fun saveAtividade(atividade: AtividadeEntity): AtividadeEntity {
        return atividadeRepository.save(atividade)
    }

    override fun updateAtividade(atividade: AtividadeEntity): AtividadeEntity {
        return atividadeRepository.save(atividade)
    }

    // Métodos relacionados ao Professor
    override fun findProfessorById(id: Long): ProfessorEntity? {
        return professorRepository.findById(id).orElse(null)
    }

    override fun saveProfessor(professor: ProfessorEntity): ProfessorEntity {
        return professorRepository.save(professor)
    }

    override fun updateProfessor(professor: ProfessorEntity): ProfessorEntity {
        return professorRepository.save(professor)
    }

    // Métodos relacionados ao Contexto
    override fun findContextoById(id: Long): ContextoEntity? {
        return contextoRepository.findById(id).orElse(null)
    }

    override fun findContextoPadrao(): ContextoEntity? {
        // Implementar a lógica para buscar o contexto padrão
        // Por exemplo, buscar o primeiro contexto na tabela
        return contextoRepository.findFirstByOrderByIdContextoAsc()
    }

    override fun saveContexto(contexto: ContextoEntity): ContextoEntity {
        return contextoRepository.save(contexto)
    }

    override fun updateContexto(contexto: ContextoEntity): ContextoEntity {
        return contextoRepository.save(contexto)
    }

    // Métodos relacionados à Oficina
    override fun findOficinaById(id: Long): OficinaEntity? {
        return oficinaRepository.findById(id).orElse(null)
    }

    override fun saveOficina(oficina: OficinaEntity): OficinaEntity {
        return oficinaRepository.save(oficina)
    }

    // Métodos relacionados à Turma
    override fun findTurmaById(id: Long): TurmaEntity? {
        return turmaRepository.findById(id).orElse(null)
    }

    override fun saveTurma(turma: TurmaEntity): TurmaEntity {
        return turmaRepository.save(turma)
    }

    // Métodos relacionados à Resposta
    override fun findRespostaById(id: Long): RespostaEntity? {
        return respostaRepository.findById(id).orElse(null)
    }

    override fun saveResposta(resposta: RespostaEntity): RespostaEntity {
        return respostaRepository.save(resposta)
    }
}
