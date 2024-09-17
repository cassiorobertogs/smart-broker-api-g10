package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.adapters.output.repositories.*
import br.com.codamundo.smart_broker_api_g10.application.ports.output.DatabaseOutput
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.DatabaseException
import br.com.codamundo.smart_broker_api_g10.domain.exceptions.NotFoundException
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.*
import org.slf4j.LoggerFactory
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Component

@Component
class DatabaseGatewayImpl(
    private val alunoRepository: AlunoRepository,
    private val atividadeRepository: AtividadeRepository,
    private val professorRepository: ProfessorRepository,
    private val contextoRepository: ContextoRepository,
    private val oficinaRepository: OficinaRepository,
    private val turmaRepository: TurmaRepository,
    private val respostaRepository: RespostaRepository
) : DatabaseOutput {

    private val logger = LoggerFactory.getLogger(DatabaseGatewayImpl::class.java)

    // Métodos relacionados ao Aluno
    override fun findAlunoById(id: Long): AlunoEntity? {
        return try {
            alunoRepository.findById(id).orElse(null)
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar o aluno com id $id.", e)
            throw DatabaseException("Erro ao buscar o aluno com id $id.", e)
        }
    }

    override fun findAllAlunos(): List<AlunoEntity> {
        return try {
            alunoRepository.findAll()
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar todos os alunos.", e)
            throw DatabaseException("Erro ao buscar todos os alunos.", e)
        }
    }

    override fun saveAluno(aluno: AlunoEntity): AlunoEntity {
        return try {
            alunoRepository.save(aluno)
        } catch (e: DataAccessException) {
            logger.error("Erro ao salvar o aluno.", e)
            throw DatabaseException("Erro ao salvar o aluno.", e)
        }
    }

    override fun deleteAluno(id: Long) {
        try {
            if (!alunoRepository.existsById(id)) {
                logger.warn("Aluno não encontrado com id $id para exclusão.")
                throw NotFoundException("Aluno não encontrado com id $id.")
            }
            alunoRepository.deleteById(id)
        } catch (e: DataAccessException) {
            logger.error("Erro ao deletar o aluno com id $id.", e)
            throw DatabaseException("Erro ao deletar o aluno com id $id.", e)
        }
    }

    // Métodos relacionados à Atividade
    override fun findAtividadeById(id: Long): AtividadeEntity? {
        return try {
            atividadeRepository.findById(id).orElse(null)
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar a atividade com id $id.", e)
            throw DatabaseException("Erro ao buscar a atividade com id $id.", e)
        }
    }

    override fun findAllAtividades(): List<AtividadeEntity> {
        return try {
            atividadeRepository.findAll()
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar todas as atividades.", e)
            throw DatabaseException("Erro ao buscar todas as atividades.", e)
        }
    }

    override fun saveAtividade(atividade: AtividadeEntity): AtividadeEntity {
        return try {
            atividadeRepository.save(atividade)
        } catch (e: DataAccessException) {
            logger.error("Erro ao salvar a atividade.", e)
            throw DatabaseException("Erro ao salvar a atividade.", e)
        }
    }

    override fun deleteAtividade(id: Long) {
        try {
            if (!atividadeRepository.existsById(id)) {
                logger.warn("Atividade não encontrada com id $id para exclusão.")
                throw NotFoundException("Atividade não encontrada com id $id.")
            }
            atividadeRepository.deleteById(id)
        } catch (e: DataAccessException) {
            logger.error("Erro ao deletar a atividade com id $id.", e)
            throw DatabaseException("Erro ao deletar a atividade com id $id.", e)
        }
    }

    // Métodos relacionados ao Professor
    override fun findProfessorById(id: Long): ProfessorEntity? {
        return try {
            professorRepository.findById(id).orElse(null)
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar o professor com id $id.", e)
            throw DatabaseException("Erro ao buscar o professor com id $id.", e)
        }
    }

    override fun findAllProfessores(): List<ProfessorEntity> {
        return try {
            professorRepository.findAll()
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar todos os professores.", e)
            throw DatabaseException("Erro ao buscar todos os professores.", e)
        }
    }

    override fun saveProfessor(professor: ProfessorEntity): ProfessorEntity {
        return try {
            professorRepository.save(professor)
        } catch (e: DataAccessException) {
            logger.error("Erro ao salvar o professor.", e)
            throw DatabaseException("Erro ao salvar o professor.", e)
        }
    }

    override fun deleteProfessor(id: Long) {
        try {
            if (!professorRepository.existsById(id)) {
                logger.warn("Professor não encontrado com id $id para exclusão.")
                throw NotFoundException("Professor não encontrado com id $id.")
            }
            professorRepository.deleteById(id)
        } catch (e: DataAccessException) {
            logger.error("Erro ao deletar o professor com id $id.", e)
            throw DatabaseException("Erro ao deletar o professor com id $id.", e)
        }
    }

    // Métodos relacionados ao Contexto
    override fun findContextoById(id: Long): ContextoEntity? {
        return try {
            contextoRepository.findById(id).orElse(null)
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar o contexto com id $id.", e)
            throw DatabaseException("Erro ao buscar o contexto com id $id.", e)
        }
    }

    override fun findAllContextos(): List<ContextoEntity> {
        return try {
            contextoRepository.findAll()
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar todos os contextos.", e)
            throw DatabaseException("Erro ao buscar todos os contextos.", e)
        }
    }

    override fun findContextoPadrao(): ContextoEntity? {
        return try {
            contextoRepository.findFirstByOrderByIdContextoAsc()
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar o contexto padrão.", e)
            throw DatabaseException("Erro ao buscar o contexto padrão.", e)
        }
    }

    override fun saveContexto(contexto: ContextoEntity): ContextoEntity {
        return try {
            contextoRepository.save(contexto)
        } catch (e: DataAccessException) {
            logger.error("Erro ao salvar o contexto.", e)
            throw DatabaseException("Erro ao salvar o contexto.", e)
        }
    }

    override fun deleteContexto(id: Long) {
        try {
            if (!contextoRepository.existsById(id)) {
                logger.warn("Contexto não encontrado com id $id para exclusão.")
                throw NotFoundException("Contexto não encontrado com id $id.")
            }
            contextoRepository.deleteById(id)
        } catch (e: DataAccessException) {
            logger.error("Erro ao deletar o contexto com id $id.", e)
            throw DatabaseException("Erro ao deletar o contexto com id $id.", e)
        }
    }

    // Métodos relacionados à Oficina
    override fun findOficinaById(id: Long): OficinaEntity? {
        return try {
            oficinaRepository.findById(id).orElse(null)
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar a oficina com id $id.", e)
            throw DatabaseException("Erro ao buscar a oficina com id $id.", e)
        }
    }

    override fun findAllOficinas(): List<OficinaEntity> {
        return try {
            oficinaRepository.findAll()
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar todas as oficinas.", e)
            throw DatabaseException("Erro ao buscar todas as oficinas.", e)
        }
    }

    override fun saveOficina(oficina: OficinaEntity): OficinaEntity {
        return try {
            oficinaRepository.save(oficina)
        } catch (e: DataAccessException) {
            logger.error("Erro ao salvar a oficina.", e)
            throw DatabaseException("Erro ao salvar a oficina.", e)
        }
    }

    override fun deleteOficina(id: Long) {
        try {
            if (!oficinaRepository.existsById(id)) {
                logger.warn("Oficina não encontrada com id $id para exclusão.")
                throw NotFoundException("Oficina não encontrada com id $id.")
            }
            oficinaRepository.deleteById(id)
        } catch (e: DataAccessException) {
            logger.error("Erro ao deletar a oficina com id $id.", e)
            throw DatabaseException("Erro ao deletar a oficina com id $id.", e)
        }
    }

    // Métodos relacionados à Turma
    override fun findTurmaById(id: Long): TurmaEntity? {
        return try {
            turmaRepository.findById(id).orElse(null)
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar a turma com id $id.", e)
            throw DatabaseException("Erro ao buscar a turma com id $id.", e)
        }
    }

    override fun findAllTurmas(): List<TurmaEntity> {
        return try {
            turmaRepository.findAll()
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar todas as turmas.", e)
            throw DatabaseException("Erro ao buscar todas as turmas.", e)
        }
    }

    override fun saveTurma(turma: TurmaEntity): TurmaEntity {
        return try {
            turmaRepository.save(turma)
        } catch (e: DataAccessException) {
            logger.error("Erro ao salvar a turma.", e)
            throw DatabaseException("Erro ao salvar a turma.", e)
        }
    }

    override fun deleteTurma(id: Long) {
        try {
            if (!turmaRepository.existsById(id)) {
                logger.warn("Turma não encontrada com id $id para exclusão.")
                throw NotFoundException("Turma não encontrada com id $id.")
            }
            turmaRepository.deleteById(id)
        } catch (e: DataAccessException) {
            logger.error("Erro ao deletar a turma com id $id.", e)
            throw DatabaseException("Erro ao deletar a turma com id $id.", e)
        }
    }

    // Métodos relacionados à Resposta
    override fun findRespostasByAlunoId(alunoId: Long): List<RespostaEntity> {
        return try {
            val respostas = respostaRepository.findByAluno_AlunoId(alunoId)
            if (respostas.isEmpty()) {
                logger.warn("Nenhuma resposta encontrada para o aluno com id $alunoId.")
            }
            respostas
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar as respostas do aluno com id $alunoId.", e)
            throw DatabaseException("Erro ao buscar as respostas do aluno com id $alunoId.", e)
        }
    }

    override fun findRespostaById(id: Long): RespostaEntity? {
        return try {
            respostaRepository.findById(id).orElse(null)
        } catch (e: DataAccessException) {
            logger.error("Erro ao buscar a resposta com id $id.", e)
            throw DatabaseException("Erro ao buscar a resposta com id $id.", e)
        }
    }

    override fun saveResposta(resposta: RespostaEntity): RespostaEntity {
        return try {
            respostaRepository.save(resposta)
        } catch (e: DataAccessException) {
            logger.error("Erro ao salvar a resposta.", e)
            throw DatabaseException("Erro ao salvar a resposta.", e)
        }
    }

    override fun deleteRespostasByAtividadeId(atividadeId: Long) {
        try {
            val respostas = respostaRepository.findByAtividade_AtividadeId(atividadeId)
            if (respostas.isEmpty()) {
                logger.warn("Nenhuma resposta encontrada para a atividade com id $atividadeId para exclusão.")
                throw NotFoundException("Nenhuma resposta encontrada para a atividade com id $atividadeId.")
            }
            respostaRepository.deleteAll(respostas)
        } catch (e: DataAccessException) {
            logger.error("Erro ao deletar as respostas da atividade com id $atividadeId.", e)
            throw DatabaseException("Erro ao deletar as respostas da atividade com id $atividadeId.", e)
        }
    }
}
