package br.com.codamundo.smart_broker_api_g10.adapters.output.repositories

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.ContextoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContextoRepository : JpaRepository<ContextoEntity, Long> {

    // Adicionando o método necessário para o DatabaseGatewayImpl
    fun findFirstByOrderByIdContextoAsc(): ContextoEntity?
}
