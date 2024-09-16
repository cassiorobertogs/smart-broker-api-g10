package br.com.codamundo.smart_broker_api_g10.infra.database.entities

import jakarta.persistence.*

@Entity
data class AlunoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    val alunoId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id", nullable = false)
    val turma: TurmaEntity,

    @Column
    val nome: String? = null,

    @Column
    val idade: Int? = null,

    @Column(name = "pessoa_com_deficiencia")
    val pessoaComDeficiencia: Boolean? = false,

    @Column(name = "tipo_de_deficiencia")
    val tipoDeDeficiencia: String? = null,

    @Column(name = "estilo_aprendizagem")
    val estiloAprendizagem: String? = null,

    @Column(name = "interesses_hobbies")
    val interessesHobbies: String? = null,

    @Column(name = "passa_tempo_preferido")
    val passaTempoPreferido: String? = null,

    @Column(name = "filme_serie_preferido")
    val filmeSeriePreferido: String? = null,

    @Column
    val artista: String? = null
)
