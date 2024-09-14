package br.com.codamundo.smart_broker_api_g10.domain.models

import br.com.codamundo.smart_broker_api_g10.infra.database.entities.AlunoEntity
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.AtividadeEntity
import br.com.codamundo.smart_broker_api_g10.infra.database.entities.ContextoEntity

data class AgenteModel(
    val aluno: AlunoEntity,
    val atividade: AtividadeEntity,
    val contexto: ContextoEntity,
    val respostaDoAluno: String
)
