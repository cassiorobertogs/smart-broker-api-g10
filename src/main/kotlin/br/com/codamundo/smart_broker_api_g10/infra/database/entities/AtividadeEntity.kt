package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class AtividadeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "id_oficina", nullable = false)
    val oficina: OficinaEntity,  // Relacionamento com a Oficina

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    val turma: TurmaEntity,  // Relacionamento com a Turma

    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = false)
    val professor: ProfessorEntity,  // Relacionamento com o Professor

    @Column(nullable = false)
    val enunciado: String,

    @Column(name = "resposta_esperada", nullable = false)
    val respostaEsperada: String,

    @Column(name = "area_conhecimento", nullable = false)
    val areaConhecimento: String,

    @Column(name = "nivel_dificuldade", nullable = false)
    val nivelDificuldade: String,

    @Column(name = "objetivos_aprendizagem", nullable = false)
    val objetivosAprendizagem: String
)
