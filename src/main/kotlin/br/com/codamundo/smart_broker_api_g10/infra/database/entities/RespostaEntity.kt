package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Iresposta")
data class RespostaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resposta")
    val idResposta: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    val aluno: AlunoEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_id", nullable = false)
    val atividade: AtividadeEntity,

    @Column(name = "resposta_aluno", nullable = false, columnDefinition = "TEXT")
    val respostaAluno: String,

    @Column(name = "resposta_correcao", nullable = false, columnDefinition = "TEXT")
    val respostaCorrecao: String,

    @Column(name = "coeficiente_acertividade", nullable = false)
    val coeficienteAcertividade: Double,

    @Column(name = "data_hora_resposta", nullable = false, updatable = false)
    val dataHoraResposta: LocalDateTime = LocalDateTime.now()
)
