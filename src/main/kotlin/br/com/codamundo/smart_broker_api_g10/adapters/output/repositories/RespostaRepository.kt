package br.com.codamundo.smart_broker_api_g10.adapters.output.repositories

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.RespostaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RespostaRepository : JpaRepository<RespostaEntity, Long> {

    // Buscar todas as respostas de um aluno específico
    fun findByAlunoId(alunoId: Long): List<RespostaEntity>

    // Buscar todas as respostas associadas a uma atividade específica
    fun findByAtividadeId(atividadeId: Long): List<RespostaEntity>

}
