package br.com.codamundo.smart_broker_api_g10.adapters.output.gateways

import br.com.codamundo.smart_broker_api_g10.domain.models.*
import br.com.codamundo.smart_broker_api_g10.adapters.output.repositories.*
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
    override fun findAlunoById(id: Long): Aluno? {
        return alunoRepository.findById(id).orElse(null)
    }

    override fun saveAluno(aluno: Aluno): Aluno {
        return alunoRepository.save(aluno)
    }

    override fun updateAluno(aluno: Aluno): Aluno {
        return alunoRepository.save(aluno)
    }

    // Métodos relacionados à Atividade
    override fun findAtividadeById(id: Long): Atividade? {
        return atividadeRepository.findById(id).orElse(null)
    }

    override fun saveAtividade(atividade: Atividade): Atividade {
        return atividadeRepository.save(atividade)
    }

    override fun updateAtividade(atividade: Atividade): Atividade {
        return atividadeRepository.save(atividade)
    }

    // Métodos relacionados ao Professor
    override fun findProfessorById(id: Long): Professor? {
        return professorRepository.findById(id).orElse(null)
    }

    override fun saveProfessor(professor: Professor): Professor {
        return professorRepository.save(professor)
    }

    override fun updateProfessor(professor: Professor): Professor {
        return professorRepository.save(professor)
    }

    // Métodos relacionados ao Contexto
    override fun findContextoById(id: Long): Contexto? {
        return contextoRepository.findById(id).orElse(null)
    }

    override fun saveContexto(contexto: Contexto): Contexto {
        return contextoRepository.save(contexto)
    }

    override fun updateContexto(contexto: Contexto): Contexto {
        return contextoRepository.save(contexto)
    }

    // Métodos relacionados à Oficina
    override fun findOficinaById(id: Long): Oficina? {
        return oficinaRepository.findById(id).orElse(null)
    }

    override fun saveOficina(oficina: Oficina): Oficina {
        return oficinaRepository.save(oficina)
    }

    // Métodos relacionados à Turma
    override fun findTurmaById(id: Long): Turma? {
        return turmaRepository.findById(id).orElse(null)
    }

    override fun saveTurma(turma: Turma): Turma {
        return turmaRepository.save(turma)
    }

    // Métodos relacionados à Resposta
    override fun findRespostaById(id: Long): Resposta? {
        return respostaRepository.findById(id).orElse(null)
    }

    override fun saveResposta(resposta: Resposta): Resposta {
        return respostaRepository.save(resposta)
    }
}
