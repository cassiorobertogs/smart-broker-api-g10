package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class AtividadeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_id")
    val atividadeId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina", nullable = false)
    val oficina: OficinaEntity,

    @Column
    val enunciado: String? = null,

    @Column(name = "resposta_esperada")
    val respostaEsperada: String? = null,

    @Column(name = "area_conhecimento")
    val areaConhecimento: String? = null,

    @Column(name = "nivel_dificuldade")
    val nivelDificuldade: String? = null,

    @Column(name = "objetivos_aprendizagem")
    val objetivosAprendizagem: String? = null
)
