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
    private val contextoRepository: ContextoRepository
) : DatabaseOutput {

    // Métodos relacionados ao Aluno
    override fun findAlunoById(id: Long): Aluno? {
        return alunoRepository.findById(id).orElse(null)  // Retorna null se não encontrado
    }

    override fun saveAluno(aluno: Aluno): Aluno {
        return alunoRepository.save(aluno)  // Salva e retorna o Aluno
    }

    override fun updateAluno(aluno: Aluno): Aluno {
        return alunoRepository.save(aluno)  // Atualiza e retorna o Aluno
    }

    // Métodos relacionados à Atividade
    override fun findAtividadeById(id: Long): Atividade? {
        return atividadeRepository.findById(id).orElse(null)  // Retorna null se não encontrado
    }

    override fun saveAtividade(atividade: Atividade): Atividade {
        return atividadeRepository.save(atividade)  // Salva e retorna a Atividade
    }

    override fun updateAtividade(atividade: Atividade): Atividade {
        return atividadeRepository.save(atividade)  // Atualiza e retorna a Atividade
    }

    // Métodos relacionados ao Professor
    override fun findProfessorById(id: Long): Professor? {
        return professorRepository.findById(id).orElse(null)  // Retorna null se não encontrado
    }

    override fun saveProfessor(professor: Professor): Professor {
        return professorRepository.save(professor)  // Salva e retorna o Professor
    }

    override fun updateProfessor(professor: Professor): Professor {
        return professorRepository.save(professor)  // Atualiza e retorna o Professor
    }

    // Métodos relacionados ao Contexto
    override fun findContextoById(id: Long): Contexto? {
        return contextoRepository.findById(id).orElse(null)  // Retorna null se não encontrado
    }

    override fun saveContexto(contexto: Contexto): Contexto {
        return contextoRepository.save(contexto)  // Salva e retorna o Contexto
    }

    override fun updateContexto(contexto: Contexto): Contexto {
        return contextoRepository.save(contexto)  // Atualiza e retorna o Contexto
    }
}
