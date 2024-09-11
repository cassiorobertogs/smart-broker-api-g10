package br.com.codamundo.smart_broker_api_g10.adapters.output.repositories

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.RespostaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RespostaRepository : JpaRepository<RespostaEntity, Long>
